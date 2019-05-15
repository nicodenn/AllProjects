var timer = setTimeout(function() {alert("page time out"); location.reload(); }, 30000)
function validateForm(event)
{
    var form = document.getElementById("form");
    var name = document.getElementById("name");
    var email = document.getElementById("email");

    if(name.value.length > 3 && name.value.includes(" "))
    {
        name.style.backgroundColor = "LightGreen";
    }
    else{
        name.style.backgroundColor = "Pink";
    }

    var regexEmail = new RegExp(/.+@\w+.(com)$|(net)$|(org)$|(edu)$/)

    if(!regexEmail.test(email.value))
    {
        email.style.backgroundColor = "Pink";
    }  
    else{
        email.style.backgroundColor = "LightGreen"; 
    }
    event.preventDefault();

}