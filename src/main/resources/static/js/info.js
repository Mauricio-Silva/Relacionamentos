// Envia o id da turma para o Save
// function RegisterObj() {
//     var select = document.getElementById("RegisterModalSelectTurma");
//     var id = select.options[select.selectedIndex].value;
//     document.getElementById("RegisterModalForm").action = "/teacher/save/" + id;
// }









//--- Artist ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
function DeleteArt(id) {
    document.getElementById("DeleteModalButton").href = "/artist/delete/" + id;
}
function UpdateArt(id, name) {
    document.getElementById("UpdateModalForm").action = "/artist/update/" + id;
    document.getElementById("UpdateModalInputName").value = name;
}
function InfoArt(id, name, webtoons) {
    document.getElementById("InfoModalLabel").innerHTML = name;
    document.getElementById("ArtInfoId").innerHTML = id;
    document.getElementById("ArtInfoWebtoons").innerHTML = webtoons;
}
function AssArtToWeb(id) {
    var webtoonId = document.getElementById("AssModalSelectWebtoon").value;
    document.getElementById("AssModalLink").href = "/artist/ass/" + id + "/" + webtoonId;
}
function AssArtToWebBySelect() {
    var url = document.getElementById("AssModalLink").href;
    var url = url.substr(0, url.length - 1)
    var webtoonId = document.getElementById("AssModalSelectWebtoon").value;
    document.getElementById("AssModalLink").href = url + webtoonId;
}





//--- Genres ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
function DeleteGen(id) {
    document.getElementById("DeleteModalButton").href = "/artist/delete/" + id;
}
function UpdateGen(id, name) {
    document.getElementById("UpdateModalForm").action = "/artist/update/" + id;
    document.getElementById("UpdateModalInputName").value = name;
}
function InfoGen(id, name, webtoons) {
    document.getElementById("InfoModalLabel").innerHTML = name;
    document.getElementById("GenInfoId").innerHTML = id;
    document.getElementById("GenInfoWebtoons").innerHTML = webtoons;
}
function AssGenToWeb(id) {
    var webtoonId = document.getElementById("AssModalSelectWebtoon").value;
    document.getElementById("AssModalLink").href = "/artist/ass/" + id + "/" + webtoonId;
}
function AssGenToWebBySelect() {
    var url = document.getElementById("AssModalLink").href;
    var url = url.substr(0, url.length - 1)
    var webtoonId = document.getElementById("AssModalSelectWebtoon").value;
    document.getElementById("AssModalLink").href = url + webtoonId;
}





//--- Webtoon ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------>
function InfoWeb(publisher, artist, genres) {
    var TableInfoPublisher = document.getElementById("TableInfoPublisher");
    var TableInfoArtist = document.getElementById("TableInfoArtist");
    var TableInfoGenres = document.getElementById("TableInfoGenres");

    if (publisher != 'null') {
        console.log(new Publisher(publisher));
    } 


    // document.getElementById("WebInfoName").innerHTML = name;
    // document.getElementById("WebInfoId").innerHTML = id;
    // document.getElementById("WebInfoChapters").innerHTML = chapters;
    // var publisherName = publisher.slice(publisher.indexOf("name") + 5, publisher.indexOf(")"))
    // document.getElementById("WebInfoPublisher").innerHTML = publisherName;
    // document.getElementById("WebInfoArtist").innerHTML = artist;
    // document.getElementById("WebInfoGenres").innerHTML = genres;
}



class Publisher {
    constructor(id, name) {
      this.id = id; 
      this.name = name;
    }

    get id() {
        return this.id;
    }

    get name() {
        return this.name;
    }
}



//--- Associate Objects -------------------------------------------------------------------------------------------------------------------------------------------------------------------->
function AssRelOwner(selectID, LinkID, URL, ObjID) {
    var selectedItem = document.getElementById(selectID).value;
    document.getElementById(LinkID).href = URL + "/" + ObjID + "/" + selectedItem;
}



function AssRelItem(LinkID, selectID) {
    var url = document.getElementById(LinkID).href;
    var url = url.substr(0, url.length - 1)
    var selectedItem = document.getElementById(selectID).value;
    document.getElementById(LinkID).href = url + selectedItem;
}