'use strict';
 
angular.module('crudApp').controller('UsuarioController',
    ['UsuarioService', '$scope',  function( UsuarioService, $scope) {
 
        var self = this;
        self.usuario = {};
        self.usuarios=[];
 
        self.submit = submit;
        self.listarUsuario = listarUsuario;
        self.salvarUsuario = salvarUsuario;
        self.alterarUsuario = alterarUsuario;
        self.excluirUsuario = excluirUsuario;    
        self.editarUsuario =  editarUsuario;
        self.reset = reset;
 
        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;
 
        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;
 
        function submit() {
            console.log('Submitting');
            if (self.usuario.id === undefined || self.usuario.id === null) {
                console.log('Salvando novo usu&aacute;rio', self.usuario);
                salvarUsuario(self.usuario);
            } else {
            	alterarUsuario(self.usuario, self.usuario.id);
                console.log('Usu&aacute;rio atualizando com id ', self.usuario.id);
            }
        }
 
        function salvarUsuario(usuario) {
            console.log('Sobre para salvar usu&aacute;rio');
            UsuarioService.salvarUsuario(usuario)
                .then(
                    function (response) {
                        console.log('Usu&aacute;rio salvando com sucesso');
                        self.successMessage = 'Usu&aacute;rio salvando com sucesso';
                        self.errorMessage='';
                        self.done = true;
                        self.usuario={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                     //   console.error('Erro ao salvar o usuário');
                        self.errorMessage = 'Erro ao salvar o usu&aacute;rio: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }
 
        function alterarUsuario(usuario, id){
            console.log('Sobre para atualizar usu&aacute;rio');
            UsuarioService.alterarUsuario(usuario, id)
                .then(
                    function (response){
                        console.log('Atualizando o usu&aacute;rio com sucesso');
                        self.successMessage='Atualizando o usu&aacute;rio com sucesso';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Erro ao  atualizando o usu&aacute;rio');
                        self.errorMessage='Error ao atualizando o usu&aacute;rio '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }
 
        function excluirUsuario(id){
            console.log('Sobre para excluir o usu&aacute;rio com id'+id);
            UsuarioService.excluirUsuario(id)
                .then(
                    function(){
                        console.log('Usuário '+id + ' exclui com sucesso ');
                        self.successMessage='Excluído o usu&aacute;rio com sucesso';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Erro ao excluido o usu&aacute;rio'+id +', Erro :'+errResponse.data);
                        self.errorMessage='Erro ao excluido o usu&aacute;rio '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }
 
        function listarUsuario(){
            return UsuarioService.listarUsuario();
        }
 
        function editarUsuario(id) {
            self.successMessage='';
            self.errorMessage='';
            UsuarioService.getUsuario(id).then(
                function (usuario) {
                    self.usuario = usuario;
                },
                function (errResponse) {
                    console.error('Erro ao exlcuido o usu&aacute;rio ' + id + ', Erro :' + errResponse.data);
                }
            );
        }
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.usuario={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }
    ]);