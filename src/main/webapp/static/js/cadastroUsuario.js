
function formatar(mascara, documento)
{
    var i = documento.value.length;
    var saida = mascara.substring(1, 0);
    var texto = mascara.substring(i);
    if (texto.substring(0, 1) != saida)
    {
        documento.value += texto.substring(0, 1);
    }
}

function mascara(t, mask) {
    var i = t.value.length;
    var saida = mask.substring(1, 0);
    var texto = mask.substring(i);
    if (texto.substring(0, 1) != saida)
    {
        t.value += texto.substring(0, 1);
    }

}





