const contentElementId = 'current-planning-session-data';
const sessionId = window.location.pathname.split('/').pop();
console.log('sessionId: ', sessionId)

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
    console.log('----------------')
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

            console.log("currentContentHash: ", currentContentHash);
            console.log("responseContentHash: ", responseContentHash);

            if (responseContentHash !== currentContentHash) {
                console.log('>>> CONTENT CHANGED !!!')
                document.getElementById(contentElementId).innerHTML = responseContent;
            }
        },
        error: function (error) {
            console.error('Error fetching updates:', error);
        }
    });
    console.log('-------+---------')
    console.log('---------+-------')
}

setInterval(checkForUpdates, 1500);
