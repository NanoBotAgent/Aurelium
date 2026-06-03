import { Client } from 'mineflayer';

const client = new Client({
  host: '127.0.0.1',
  port: 25565,
  username: 'TestBot',
  version: false
});

client.on('error', (err) => {
  console.error('Bot error:', err);
  process.exit(1);
});

client.on('login', () => {
  console.log('Bot joined the server');
  client.chat('/version');
});

client.on('message', (msg) => {
  console.log('Server:', msg.extra !== undefined ? msg.extra.map((part) => part.text).join('') : msg.toString());
  if (msg.toString().includes('Testing Chat')) {
    console.log('Detected test message - passing');
    client.end();
    process.exit(0);
  }
  if (msg.toString().includes('FAIL')) {
    console.log('Detected FAIL - exiting with error');
    client.end();
    process.exit(1);
  }
});

client.on('end', () => {
  console.log('Disconnected');
  process.exit(0);
});

setTimeout(() => {
  console.log('Timeout waiting for response');
  client.end();
  process.exit(1);
}, 60000);

client.connect();
