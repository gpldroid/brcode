import QRCode from 'qrcode';

export type QRRenderOptions = {
  size?: number;
  margin?: number;
  dark?: string;
  light?: string;
};

export async function renderQR(
  canvas: HTMLCanvasElement,
  value: string,
  options: QRRenderOptions = {},
): Promise<void> {
  await QRCode.toCanvas(canvas, value, {
    width: options.size ?? 320,
    margin: options.margin ?? 2,
    color: {
      dark: options.dark ?? '#111827',
      light: options.light ?? '#ffffff',
    },
    errorCorrectionLevel: 'M',
  });
}

export async function createQRDataUrl(
  value: string,
  options: QRRenderOptions = {},
): Promise<string> {
  return QRCode.toDataURL(value, {
    width: options.size ?? 1024,
    margin: options.margin ?? 2,
    color: {
      dark: options.dark ?? '#111827',
      light: options.light ?? '#ffffff',
    },
    errorCorrectionLevel: 'M',
  });
}
