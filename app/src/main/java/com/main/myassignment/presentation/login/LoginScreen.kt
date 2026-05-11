package com.main.myassignment.presentation.login

import androidx.compose.foundation.background
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.main.myassignment.core.customComponent.button.AppButton
import com.main.myassignment.core.customComponent.button.model.ButtonVariant
import com.main.myassignment.core.customComponent.text.AppText
import com.main.myassignment.core.customComponent.text.AppTextField
import com.main.myassignment.core.customComponent.text.model.AppTextFieldStyle
import com.main.myassignment.core.customComponent.text.model.AppTextStyle
import com.main.myassignment.presentation.theme.color.LocalAppExtendedColor
import com.main.myassignment.core.customComponent.button.model.AppButtonStyle
import com.main.myassignment.core.customComponent.card.AppCard
import com.main.myassignment.core.customComponent.card.model.AppCardStyle
import com.main.myassignment.presentation.theme.dimens.sdp

@Composable
fun LoginScreen(vm: LoginViewModel, onLoginSuccess: () -> Unit) {

    val colors = LocalAppExtendedColor.current

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.backgroundBrandPressed)
            .padding(20.dp)
    ) {

        val (card) = createRefs()


        AppCard(
            modifier  = Modifier
                .constrainAs(card) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth()
                .wrapContentHeight(),
            style = AppCardStyle(
                backgroundColor = colors.backgroundPrimary,
                shape = RoundedCornerShape(
                    24.sdp
                ),
                elevation = 6.sdp,
                borderColor = colors.borderPrimary
            )
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {

                val (
                    title,
                    subtitle,
                    email,
                    password,
                    loginBtn,
                    forgot
                ) = createRefs()

                // TITLE
                AppText(
                    text = "Welcome Back 👋",
                    style = AppTextStyle.h3Bold(colors.contentPrimary),
                    modifier = Modifier.constrainAs(title) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                    textAlign = TextAlign.Center
                )

                // SUBTITLE
                AppText(
                    text = "Login to continue your journey",
                    style = AppTextStyle.bodyRegular(colors.contentSecondary),
                    modifier = Modifier.constrainAs(subtitle) {
                        top.linkTo(title.bottom, margin = 8.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                    textAlign = TextAlign.Center
                )

                // EMAIL
                AppTextField(
                    value = vm.email,
                    onValueChange = { vm.email = it },
                    style = AppTextFieldStyle(
                        placeholderText = "Email",
                        singleLine = true,
                        backgroundColor = colors.backgroundSecondary,
                        textStyle = AppTextStyle.bodyRegular(colors.contentPrimary)
                    ),
                    modifier = Modifier.constrainAs(email) {
                        top.linkTo(subtitle.bottom, margin = 32.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    }
                )

                // PASSWORD
                AppTextField(
                    value = vm.password,
                    onValueChange = { vm.password = it },
                    style = AppTextFieldStyle(
                        placeholderText = "Password",
                        singleLine = true,
                        backgroundColor = colors.backgroundSecondary,
                        textStyle = AppTextStyle.bodyRegular(colors.contentPrimary)
                    ),
                    visualTransformation = PasswordVisualTransformation(), // 🔥 ADD THIS
                    modifier = Modifier.constrainAs(password) {
                        top.linkTo(email.bottom, margin = 16.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    }
                )

                // LOGIN BUTTON

                AppButton(
                    text = "Login",
                    onClick = {
                        vm.login()
                        onLoginSuccess()},
                        style = AppButtonStyle(cornerRadius = 16,
                        enabled = vm.isValid,
                        textStyle = AppTextStyle.bodyRegular(color = colors.backgroundPrimary)
                    ),
                    variant = ButtonVariant.Filled,
                    modifier = Modifier
                        .constrainAs(loginBtn) {
                            top.linkTo(password.bottom, margin = 24.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            width = Dimension.fillToConstraints
                        }
                        .height(52.dp),
                )

                // FORGOT PASSWORD
                AppText(
                    text = "Forgot Password?",
                    style = AppTextStyle.footnote(colors.contentLink),
                    modifier = Modifier.constrainAs(forgot) {
                        top.linkTo(loginBtn.bottom, margin = 16.dp)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    },
                    textAlign = TextAlign.End
                )
            }
        }
    }
}
