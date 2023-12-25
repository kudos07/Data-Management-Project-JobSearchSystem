function handleKeyPress(event, userType) {
    if (event.keyCode === 13) { // 13 is the keycode for Enter
        login(userType);
    }
}

// Add carousel functionality here
document.addEventListener('DOMContentLoaded', function() {
    const sections = document.querySelectorAll('.login-section');
    let currentSectionIndex = 0;
    let isScrolling = false;

    window.addEventListener('wheel', function(event) {
        if (isScrolling) return;

        if (event.deltaY > 0) {
            // Scrolling down
            currentSectionIndex = (currentSectionIndex + 1) % sections.length;
        } else {
            // Scrolling up
            currentSectionIndex = (currentSectionIndex - 1 + sections.length) % sections.length;
        }

        sections[currentSectionIndex].scrollIntoView({ behavior: 'smooth' });
        isScrolling = true;
        setTimeout(() => isScrolling = false, 1000); // Prevents rapid section changes
    });
});



function login(userType) {
    let username = document.getElementById(userType + '-username').value;
    let password = document.getElementById(userType + '-password').value;
    
    // Construct the data to send in the POST request
    const loginData = { username, password, userType };
  
    // Make the POST request to the server
    fetch('/api/login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(loginData)
    })
    .then(response => response.json())
    .then(data => {
      if (data.success) {
        window.location.href = data.redirectUrl;
      } else {
        // Handle login failure
        alert(data.message);
      }
    })
    .catch(error => {
      // Handle errors
      console.error('Error:', error);
    });
  }
  
  


