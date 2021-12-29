function InserirMusica(value)
{
    event.preventDefault(); 
                
   const URL_TO_FETCH = 'GravaMusica';//servlet

   var formData = new FormData(document.getElementById("cadmusic"));
   
                
   fetch(URL_TO_FETCH, { method: 'post',body: formData 
   }).then(function (response) {
        return response.text();
   }).then(function (retorno) {
   
                  
        if (retorno.startsWith('Erro')) 
        {
            document.getElementById('resultado').innerHTML = retorno;
        
        } else  
        {
            document.getElementById('cadmusic').reset(); 
            document.getElementById('resultado').innerHTML = retorno;
        }
   }).catch(function (error) {
        console.error(error);
   });
}
function Retorna(value)
{
    event.preventDefault();    
   
    var httpRequest = new XMLHttpRequest();
    httpRequest.open("post","./Busca");
    var formData = new FormData(value);
    const data = new URLSearchParams();

    for (const pair of formData)
        data.append(pair[0], pair[1]);
    
    httpRequest.send(data);
    
    httpRequest.onreadystatechange = function () 
    {
        if (httpRequest.readyState === 4 && httpRequest.status === 200)  
        {
            document.getElementById("resultado").innerHTML=httpRequest.responseText;
        }
    };
}
