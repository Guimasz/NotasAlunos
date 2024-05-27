// *******************************************************************************
// ***  SOMENTE A PARTIR DESTE PONTO VOCÊ PODERÁ ALTERAR O CÓDIGO
// *******************************************************************************


enviaNovo = function () {
    let dto = {
        id: '',
        turma: document.getElementById('turma').value,
        nome: document.getElementById('nome').value,
        matricula: document.getElementById('matricula').value,
        nota: document.getElementById('nota').value
    };
    if (!validarEnvio(dto)) {
        document.getElementById('mensagem').style.display = 'block';
        document.getElementById('mensagem').innerText = "Dados inválidos.";
        return;
    }
    let json = JSON.stringify(dto);
    let request = new XMLHttpRequest();
    request.open('POST', '/novoAluno', true);
    request.setRequestHeader("Content-Type", "application/json");
    request.onreadystatechange = function () {
        if (request.readyState === XMLHttpRequest.DONE) {
            if (request.status === 200) {
                window.location.href = '/';
            } else {
                document.getElementById('mensagem').style.display = 'block';
                document.getElementById('mensagem').innerText = request.responseText;
                console.log(request.responseText);
            }
        }
    }
    request.send(json);
}

validarEnvio = function (dto) {
    console.log(dto);
    let cond1 = dto.turma != "1" && dto.turma != "2";
    let cond2 = dto.nome.length < 5;
    let cond3 = dto.matricula.length < 6;
    let cond4 = parseFloat(dto.nota) < 0 || parseFloat(dto.nota) > 10;
    if (cond1 || cond2 || cond3 || cond4) {
        console.log(cond1, cond2, cond3, cond4);
        return false;
    }
    return true;
}