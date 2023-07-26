const contentElementId = 'current-planning-session-data';
const sessionId = window.location.pathname.split('/').pop();
let intervalId;

function calculateHashCode(str) {
    let hash = 0;
    for (let i = 0; i < str.length; i++) {
        const char = str.charCodeAt(i);
        hash = (hash << 5) - hash + char;
        hash = hash & hash; // Convert to 32bit integer
    }
    return hash;
}

function checkForUpdates() {
    $.ajax({
        url: '/sessions/' + sessionId,
        method: 'GET',
        dataType: 'html',
        success: function (response) {
            const tempElement = document.createElement('div');
            tempElement.innerHTML = response;
            const responseContent = tempElement.querySelector('#current-planning-session-data').innerHTML;
            const responseContentHash = calculateHashCode(responseContent);
            const currentContentHash = calculateHashCode(document.getElementById(contentElementId).innerHTML);

            if (responseContentHash !== currentContentHash) {
                document.getElementById(contentElementId).innerHTML = responseContent;
            }
        },
        error: function (error) {
            console.error('Error fetching updates:', error);
        }
    });
}

function startCheckingForUpdates() {
    intervalId = setInterval(checkForUpdates, 2000);
}

function stopCheckingForUpdates() {
    clearInterval(intervalId);
}

window.onload = function () {
    // Call the startCheckingForUpdates function when the page is loaded
    startCheckingForUpdates();
    window.addEventListener('beforeunload', function () {
        // Call the stopCheckingForUpdates function when the user leaves the page
        stopCheckingForUpdates();
    });
};
