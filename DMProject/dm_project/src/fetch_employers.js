window.onload = function() {
fetch('/api/candidates')
fetch('/api/candidates')
.then(response => response.json())
.then(candidates => {
    const candidatesList = document.getElementById('candidatesList');
    candidates.forEach(candidate => {
        const row = candidatesList.insertRow();
        const cellId = row.insertCell(0);
        const cellQualification = row.insertCell(1);
        const cellExperience = row.insertCell(2);
        
        cellId.textContent = candidate.CandidateID;
        cellQualification.textContent = candidate.Qualification;
        cellExperience.textContent = `${candidate.Experience} years`;

        const uploadButton = document.createElement('button');
        uploadButton.textContent = 'Upload Resume';
        uploadButton.classList.add('btn', 'btn-primary');
    });
})
.catch(error => console.error('Error:', error));
};