window.onload = function() {
    fetch('/api/employers')
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
        }
        return response.json();
    })
    .then(employers => {
        console.log('Employers received:', employers); // This should log the received data
        const employersList = document.getElementById('employersList');

        if (!employers || employers.length === 0) {
            console.log('No employers found or an empty array received.');
            employersList.innerHTML = '<tr><td colspan="5">No employers found.</td></tr>';
            return;
        }

        // Render the employers in the table
        employers.forEach(employer => {
            const row = employersList.insertRow();
            row.innerHTML = `
                <td>${employer.EmployerID}</td>
                <td>${employer.EnterpriseName}</td>
                <td>${employer.CEO}</td>
                <td>${employer.Location}</td>
                <td>${employer.Address}</td>
            `;
        });
    })
    .catch(error => {
        console.error('Error fetching employers:', error);
        const employersList = document.getElementById('employersList');
        employersList.innerHTML = '<tr><td colspan="5">Error fetching data.</td></tr>';
    });
};
