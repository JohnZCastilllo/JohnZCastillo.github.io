
function time(){
    let date = new Date();

    let hour = date.getHours();
    let minutes = date.getMinutes();
    let seconds = date.getSeconds();

    return hour +":" + minutes + ":" + seconds;
}

function displayTime(){
    document.getElementById("time").innerHTML = time();
}

setInterval(displayTime,1000);