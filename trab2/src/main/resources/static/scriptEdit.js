// *******************************************************************************
// ***  SOMENTE A PARTIR DESTE PONTO VOCÊ PODERÁ ALTERAR O CÓDIGO
// *******************************************************************************


enviaEdit = function(id) {
    let dto = {
        id: id,
        turma: document.getElementById('turma').value,
        nome: document.getElementById('nome').value,
        matricula: document.getElementById('matricula').value,
        nota: document.getElementById('nota').value
    };
    let json = JSON.stringify(dto);
    let request = new XMLHttpRequest();
    request.open('POST', '/updateAluno', true);
    request.setRequestHeader("Content-Type", "application/json");
    request.onreadystatechange = function () {
        if (request.readyState === XMLHttpRequest.DONE) {
            if (request.status === 200) {
                window.location.href = '/';
            } else {
                // TODO: FAZER ALGO SE DEU ERRADO
            }
        }
    }
    request.send(json);
    console.log(json);
}

deleteAluno = function(id) {
    let request = new XMLHttpRequest();
    request.open('POST', '/delete', true);
    request.setRequestHeader("Content-Type", "application/json");
    request.onreadystatechange = function () {
        if (request.readyState === XMLHttpRequest.DONE) {
            if (request.status === 200) {
                window.location.href = '/';
            } else {
                // TODO: FAZER ALGO SE DEU ERRADO
            }
        }
    }
    request.send(id);
}