
window.onload = function () {

    const nodeList = document.querySelectorAll(".form-cmt");

    for(let x = 0; x < nodeList.length; x++) {
        nodeList[x].addEventListener("submit", async (event) => {

            event.preventDefault(); // Prevent default form submission

                const playerId = event.target.getAttribute("data-playerId")

              const form = event.target;
              const formData = new FormData(form); // Collect form data

              // Convert FormData to plain object
              const data = Object.fromEntries(formData.entries());

              const dataWithExtras = { ...data, playerId };

              try {
                const response = await fetch('/assessment/addcomment', {
                  method: 'POST',
                  headers: {
                    'Content-Type': 'application/json'
                  },
                  body: JSON.stringify(dataWithExtras)
                });
                console.log(response);

                if(response.ok) {
                    form.reset();
                    alert("Comment Registered")
                }

//                const result = response.text();
//                console.log('Success:', result);

              } catch (error) {
                console.error('Error:', error);
              }
           })
    }
  };

