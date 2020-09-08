function loadSong(song){
    var s = song.lyrics;
    s = s.replaceAll("\n","</br>");
    document.getElementById("song").innerHTML=s;
}

function getSong(){
    console.log("in get song");
    let artistID=document.getElementById("artistID").value;
    let songID=document.getElementById("songID").value;
    //STEP 1
    var xhr = new XMLHttpRequest();
    //STEP 2
    xhr.onreadystatechange = function(){
        console.log("in ORSC");
        if (xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            var song=JSON.parse(xhr.responseText);
            loadSong(song);
        }
    }
    //STEP 3
    xhr.open("GET", "https://api.lyrics.ovh/v1/"+ artistID +"/" + songID);

    //STEP 4
    xhr.send();
}

window.onload=function(){
    console.log("in onload");
    document.getElementById("songsubmit").addEventListener("click",getSong,false);
}