# BRCode Android

Native Kotlin + Jetpack Compose application.

## Release signing

Release builds are signed only in GitHub Actions. No keystore or signing credentials are committed.

Required GitHub Actions secrets:
- `ANDROID_KEYSTORE_BASE64`
- `ANDROID_KEYSTORE_PASSWORD`
- `ANDROID_KEY_ALIAS`
- `ANDROID_KEY_PASSWORD`

The workflow decodes the keystore temporarily, builds a signed Release APK and AAB, uploads both as artifacts, then deletes the temporary keystore.

## Local release build

`./gradlew assembleRelease bundleRelease -PRELEASE_STORE_FILE=/absolute/path/release.keystore -PRELEASE_STORE_PASSWORD=... -PRELEASE_KEY_ALIAS=... -PRELEASE_KEY_PASSWORD=...`
