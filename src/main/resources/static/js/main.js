
window.onload = function () {

    const nodeList = document.querySelectorAll(".btn-score");

    for(let x = 0; x < nodeList.length; x++) {
        nodeList[x].addEventListener("change", (e) => {

            console.log(e.target.getAttribute("data-subject"))
           const value = e.target.value;
           const name = e.target.name;
           const subject = e.target.getAttribute("data-subject")
           const url = "/assessment/updatescore?value=" + value + "&name=" + name + "&subject=" + subject;
           console.log(url);

           fetch(url)
           .then(response => response.text())
           .then(html => {
                document.getElementById("resultContainer").innerHTML = html;
                var element = document.getElementById(e.target.name);
                console.log(element)
                element.classList.add("flag");
           })
           .catch(error => console.error('Error:', error));
           })
    }
  };

