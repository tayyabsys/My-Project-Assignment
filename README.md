# My Assignment

Android assessment app (**`com.main.myassignment`**) — login flow, posts from **JSONPlaceholder**, local cache with **Room**, and **favorites** with offline persistence. UI is **Jetpack Compose**; structure follows **MVVM** with **Clean Architecture** layers (presentation → domain → data).

---

## What the app does

### Login (`LoginScreen` + `LoginViewModel`)

- Email and password fields.
- Email validated with `Patterns.EMAIL_ADDRESS` (`core/util/Extensions.kt` → `isValidEmail()`).
- Password length **8–15** characters (`LoginViewModel.isValid`).
- **Login** button is enabled only when both are valid (`AppButton` / `AppButtonStyle.enabled = vm.isValid`).
- On tap: saves session via `SecureStorageManager` and navigates to home — **no login API call**.
- Label on screen is **“Login”** (same role as a submit action).

### Home (`HomeScreen`)

- Two tabs: **Posts** and **Favorites**.
- **Logout** in the top app bar: clears secure session and returns to login (`AppNavGraph`).

### Posts tab (`PostsScreen` + `PostViewModel`)

- List comes from **`PostRepositoryImpl`**: if **Room is empty**, posts are fetched with **Retrofit** (`ApiService`) and stored locally; afterwards the list is driven by **Flow** from the database (offline-first).
- Favorite heart toggles update UI immediately (optimistic update with rollback on failure in `PostViewModel`).

### Favorites tab (`FavoritesScreen`)

- Shows posts marked favorite in Room.
- **Swipe** reveals a red background with a **Delete** control; unfavorite happens **only after** tapping Delete (Material **Delete** icon + label).

### Session & cold start (`AppEntryPoint`)

- Reads cached login from **EncryptedSharedPreferences** (`SecureStorage` / `SecureStorageManager`).
- Starts navigation at `"login"` or `"home"` accordingly.

---

## Tech stack (as in the project)

| Area | Implementation |
|------|----------------|
| Language | **Kotlin** |
| UI | **Jetpack Compose**, Material 3, ConstraintLayout Compose |
| Architecture | **MVVM** (`ViewModel` + Compose), use cases + repository abstraction |
| DI | **Hilt** (`@HiltAndroidApp`, `@AndroidEntryPoint`, `@HiltViewModel`, `AppModule`, `DatabaseModule`) |
| Networking | **Retrofit** + **Gson** (`GsonConverterFactory`) |
| Concurrency / reactive | **Kotlin Coroutines**, **Flow** / **StateFlow** (not LiveData) |
| Local DB | **Room** (`AppDatabase`, `PostDao`, `PostEntity`) |
| Images | **Coil** (`AppImage` and related) — not Glide/Picasso |
| Secure session | **AndroidX Security Crypto** (encrypted shared preferences) |

---

## API

- **Base URL:** `https://jsonplaceholder.typicode.com/` (`core/constants/ApiConstants.kt`)
- Posts: defined in `data/remote/api/ApiService.kt` (JSONPlaceholder `/posts`).

---

## Project structure

```
app/src/main/java/com/main/myassignment/
├── core/              # Theme helpers, custom components, extensions, secure storage
├── data/              # remote (DTO, ApiService, mappers), local (Room), PostRepositoryImpl
├── domain/            # Post model, PostRepository, use cases
├── di/                # Hilt: Retrofit + repository, Room database + DAO
├── presentation/      # login, home, posts, favorites, navigation, theme
├── MainActivity.kt
└── MyApp.kt
```

---

## Requirements to build

- **Android Studio** (recommended) with a JDK compatible with **Java 11** project settings.
- **minSdk 24**, **targetSdk 36**, **compileSdk 36** (`app/build.gradle.kts`).
- **Application ID:** `com.main.myassignment`.

---

## Build & run

From the repository root:

```bash
# Windows
gradlew.bat assembleDebug

# macOS / Linux
./gradlew assembleDebug
```

Or run the **app** configuration from Android Studio on an emulator or device.

---

## Tests (TDD-friendly)

Unit tests include use cases and `PostViewModel` behavior (e.g. toggle success / rollback). Run:

```bash
./gradlew testDebugUnitTest
```

Test utilities: `app/src/test/java/com/main/myassignment/testutil/MainDispatcherRule.kt`.

---

## Assignment criteria alignment (summary)

| Criterion | Status |
|-----------|--------|
| Kotlin | Yes |
| MVVM | Yes |
| Hilt DI | Yes |
| Retrofit + Gson | Yes |
| Reactive (Coroutines / Flow) | Yes; **LiveData not used** |
| Image loading (Glide/Picasso “preferred” in brief) | **Coil** used instead |
| Login: validation, no API on submit, persisted session, logout | Yes |
| Home: Posts + Favorites tabs; posts from network when DB empty | Yes (then cached in Room) |

---

## Operational notes

- **Room:** `AppDatabase` version is defined in `data/local/database/AppDatabase.kt`. In **debug** builds, `DatabaseModule` may use `fallbackToDestructiveMigration()` for faster iteration — local data can be wiped on schema changes. Treat **release** builds with proper migrations if you ship to users.
- **Encrypted prefs:** If the OS cannot decrypt the keyset (e.g. some restore scenarios), secure storage init may reset; user may need to log in again (`SecureStorage`).

---

## License

Educational / assessment use unless the author specifies otherwise.
