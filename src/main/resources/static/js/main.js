// Envia o id da turma para o Save
// function RegisterObj() {
//     var select = document.getElementById("RegisterModalSelectTurma");
//     var id = select.options[select.selectedIndex].value;
//     document.getElementById("RegisterModalForm").action = "/teacher/save/" + id;
// }



//--- Delete Object ------------------------------------------------------------------------------------------------------------------------------------------------------------------------>
// Envia o link para o botão do Modal Delete
function DeleteObj(objName, id) {
    var btnDeleteModal = document.getElementById("DeleteModalButton");
    btnDeleteModal.setAttribute("href", objName + "/delete/" + id);
}



//--- Update Object ------------------------------------------------------------------------------------------------------------------------------------------------------------------------>
// Recebe um Objeto Model em String, mapeia as informações e as insere no Update Modal Form
function UpdateObj(obj) {
    // console.log(obj);
    var a1 = obj.indexOf("(");
    var a2 = obj.indexOf(")");

    var objName = obj.slice(0, a1).toLowerCase()
    // console.log(objName);
    var data = obj.slice(a1 + 1, a2).split(",", 7);
    // console.log(data);
    
    var lista = data.map(function(item) {
        return item.slice(item.indexOf("=") + 1, item.length);
    });
    
    // console.log(lista);
    document.getElementById("UpdateModalForm").action = "/" + objName + "/update/" + lista[0];
    
    var inputs = document.querySelectorAll(".MI");
    inputs.forEach(function(item, id) {
        // console.log(id);
        // console.log(lista[id + 1]);
        item.value = lista[id + 1];
    });
}



//--- Show Object Informations ------------------------------------------------------------------------------------------------------------------------------------------------------------->
//
function ShowWebInfo(id, name, chapters, publisher, artist, genres) {
    
    // console.log(id, name, chapters, publisher, artist, genres);

    document.getElementById("InfoModalLabel").innerHTML = name;
    document.getElementById("WebInfoId").innerHTML = id;
    document.getElementById("WebInfoChapters").innerHTML = chapters;

    var publisherName = publisher.slice(publisher.indexOf("name") + 5, publisher.indexOf(")"))
    document.getElementById("WebInfoPublisher").innerHTML = publisherName;

    document.getElementById("WebInfoArtist").innerHTML = artist;

    document.getElementById("WebInfoGenres").innerHTML = genres;
}


function ShowArtInfo(id, name, webtoons) {
    
    // console.log(id, name, webtoons);

    document.getElementById("InfoModalLabel").innerHTML = name;
    document.getElementById("ArtInfoId").innerHTML = id;

    // var publisherName = publisher.slice(publisher.indexOf("name") + 5, publisher.indexOf(")"))
    document.getElementById("ArtInfoWebtoons").innerHTML = webtoons;
}









//
function AssRelOwner(selectID, LinkID, URL, ObjID) {
    var selectedItem = document.getElementById(selectID).value;
    document.getElementById(LinkID).href = URL + "/" + ObjID + "/" + selectedItem;
}

//
function AssRelItem(LinkID, selectID) {
    var url = document.getElementById(LinkID).href;
    var url = url.substr(0, url.length - 1)
    var selectedItem = document.getElementById(selectID).value;
    document.getElementById(LinkID).href = url + selectedItem;
}