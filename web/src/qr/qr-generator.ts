import { createQRDataUrl, renderQR } from './qr-engine';

const input = document.querySelector<HTMLTextAreaElement>('#qr-input');
const canvas = document.querySelector<HTMLCanvasElement>('#qr-canvas');
const generate = document.querySelector<HTMLButtonElement>('#qr-generate');
const download = document.querySelector<HTMLButtonElement>('#qr-download');
const clear = document.querySelector<HTMLButtonElement>('#qr-clear');
const status = document.querySelector<HTMLElement>('#qr-status');

function setStatus(message: string, error = false) {
  if (!status) return;
  status.textContent = message;
  status.dataset.state = error ? 'error' : 'ready';
}

async function generateQR() {
  const value = input?.value.trim() ?? '';
  if (!value || !canvas) {
    setStatus('Enter text or a URL first.', true);
    return;
  }

  setStatus('Generating…');
  try {
    await renderQR(canvas, value);
    if (download) download.disabled = false;
    setStatus('QR code generated locally in your browser.');
  } catch {
    setStatus('Unable to generate this QR code.', true);
  }
}

generate?.addEventListener('click', generateQR);
input?.addEventListener('keydown', (event) => {
  if ((event.ctrlKey || event.metaKey) && event.key === 'Enter') generateQR();
});

download?.addEventListener('click', async () => {
  const value = input?.value.trim() ?? '';
  if (!value) return;
  const dataUrl = await createQRDataUrl(value);
  const anchor = document.createElement('a');
  anchor.href = dataUrl;
  anchor.download = 'brcode-qr.png';
  anchor.click();
});

clear?.addEventListener('click', () => {
  if (input) input.value = '';
  if (canvas) {
    const context = canvas.getContext('2d');
    context?.clearRect(0, 0, canvas.width, canvas.height);
  }
  if (download) download.disabled = true;
  setStatus('Ready');
});
