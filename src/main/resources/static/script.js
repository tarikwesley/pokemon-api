document.getElementById('apiForm').addEventListener('submit', function (event) {
    event.preventDefault();

    var name = document.getElementById('name').value;

    fetch('/api/' + encodeURIComponent(name), {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        },
    })
        .then(response => response.json())
        .then(data => {
            document.getElementById('response').innerText = JSON.stringify(data, null, 2);
        })
        .catch(error => {
            console.error('Error when sending a request:', error);
        });
});