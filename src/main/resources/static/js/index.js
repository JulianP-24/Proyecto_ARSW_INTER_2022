var Module = (function() {
    return {
        getName: function(username){
            //var name = document.getElementById("nameJs").value;
            
            var url = '/SubastaExpress/login/' + username;
            fetch(url, {
                method: 'GET'
            })
                location.href = "Comprador.html"
                
        },

        signUp: function (username, password, name, surname, email, roles) {
            //var name = document.getElementById("name").value;
            let datos = {
                    username : username,
                    password: password,
                    name: name,
                    surname: surname,
                    email: email,
                    roles: roles}
            let header = {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body:JSON.stringify(datos)
                }
            var url = '/SubastaExpress/signUp';
            fetch(url, header)
                .then(response => console.log("usuario registrado"))
            
        }
    }
})();