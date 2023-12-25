function executeQuery(queryNumber) {
    let url = '/api/run-query';
    let data = {};

    switch (queryNumber) {
        case 1:
            data = {
                location: document.getElementById('query1Location').value,
                enterpriseName: document.getElementById('query1EnterpriseName').value
            };
            break;
        case 2:
            data = {
                qualification: document.getElementById('query2Qualification').value,
                skill1: document.getElementById('query2Skill1').value,
                skill2: document.getElementById('query2Skill2').value
            };
            break;
        case 3:
                data = {
                    salary: document.getElementById('query3Salary').value,
                    year: document.getElementById('query3Year').value
                };
                break;
        case 4:
            data={}
            break;
        case 5:
            data = {
                qualification: document.getElementById('query5Qualification').value
            };
            break;

        case 6:
            data = {
                jobDescription: document.getElementById('query6JobDescription').value
            };
            break;
        case 7:
            data = {
                skillName: document.getElementById('query7SkillName').value
            };
        case 8:
            data={}
            break;
        case 9:
            data=[]
            break;
        case 10:
            data = {
                skillName: document.getElementById('query10SkillName').value
            };
            break;
        default:
            console.error('Invalid query number');
            return;
    }

    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ queryNumber, ...data })
    })
    .then(response => response.json())
    .then(data => {
        const resultsContainer = document.getElementById(`result${queryNumber}`);
        // Clear previous results
        resultsContainer.innerHTML = '';
        // Assume the server returns an array of objects and we want to render them as a list
        data.forEach(item => {
            const itemElement = document.createElement('div');
            Object.entries(item).forEach(([key, value]) => {
                const p = document.createElement('p');
                p.textContent = `${key}: ${value}`;
                itemElement.appendChild(p);
            });
            resultsContainer.appendChild(itemElement);
        });
    })
    .catch(error => {
        console.error('Error:', error);
    });
}
