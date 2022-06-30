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
            var url = '/SubastaExpress/signUp';
            fetch(url, {
                method: 'POST',
                dataType: "JSON",
                contentType: "application/json; charset=UTF-8",
                body:{
                    "username": username,
                    "password": password,
                    "name": name,
                    "surname": surname,
                    "email": email,
                    "roles": roles
                },
            })
                .then(response => console.log("usuario registrado"))
            
        }
        //
    }
})();