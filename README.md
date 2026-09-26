# BRCode

BRCode is a QR Code web and Android project designed for GitHub Pages, Firebase and AdMob.

## Project architecture

- `web/` — static web application deployed with GitHub Pages.
- `android/` — native Android application.
- `shared/` — shared specifications and documentation.
- `.github/workflows/` — CI/CD workflows.
- `docs/` — architecture and deployment documentation.

## Hosting

The web application is designed for GitHub Pages and does not require a custom domain.

## Services

- Firebase for supported application services, analytics and crash infrastructure.
- AdMob for Android application advertising.

## Development

The `main` branch remains the stable project branch. Major reconstruction work is performed on `rebuild/v2` before release.

## Security

Secrets, signing keys and service credentials must never be committed to the repository.
