# BRCode V2 Architecture

## Goals

1. Preserve the existing QR functionality while rebuilding the project cleanly.
2. Keep the web application static and deployable on GitHub Pages without a custom domain.
3. Keep Android as a native application rather than a WebView wrapper.
4. Integrate Firebase and AdMob through dedicated application layers.
5. Keep web, Android and shared specifications separated.

## Repository layout

```text
web/       Static web application
android/   Native Android application
shared/    Shared specifications and documentation
docs/      Technical documentation
.github/   CI/CD
```

## Web architecture

The web application is component-oriented. Page structure, reusable UI, styles and QR logic are separated. GitHub Pages path handling must be treated as a first-class deployment requirement.

## Android architecture

The Android application will use Kotlin and Jetpack Compose. QR generation, UI, Firebase and advertising integrations remain separated so that each can evolve independently.

## Services

Firebase is an application service layer. AdMob is an Android advertising layer. No private credentials or signing keys are committed to Git.
