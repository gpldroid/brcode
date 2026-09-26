# Shared QR Specification

The QR feature is defined independently from the web UI and Android UI.

## Data flow

```text
User input -> validation -> QR payload -> QR renderer -> preview/export
```

## Required capabilities

- Text
- URL
- Wi-Fi
- Email
- Phone
- SMS
- Contact/vCard

Additional formats can be added without changing the presentation layer.
