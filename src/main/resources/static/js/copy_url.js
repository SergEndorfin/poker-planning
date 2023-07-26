const copyButton = document.getElementById('copyUrlButton');
const linkElement = document.querySelector('a[data-clipboard-text]');

copyButton.addEventListener('click', () => {
    const urlToCopy = linkElement.getAttribute('data-clipboard-text');

    navigator.clipboard.writeText(urlToCopy)
        .then(() => {
            console.log('URL copied to clipboard:', urlToCopy);
        })
        .catch((error) => {
            console.error('Failed to copy URL to clipboard:', error);
        });
});
