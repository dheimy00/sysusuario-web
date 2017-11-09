'use strict';

angular.module('crudApp').factory('UsuarioService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                loadAllUsers: loadAllUsers,
                listarUsuario: listarUsuario,
                getUsuario: getUsuario,
                salvarUsuario: salvarUsuario,
                alterarUsuario: alterarUsuario,
                excluirUsuario: excluirUsuario
            };

            return factory;

            function loadAllUsers() {
                console.log('Todos dados de usu&aacute;rios');
                var deferred = $q.defer();
                $http.get(urls.USER_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Todos dados de usu&aacute;rio com sucesso');
                            $localStorage.usuarios = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                          console.error('Erro ao carregar usu&aacute;rios');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function listarUsuario(){
                return $localStorage.usuarios;
            }

            function getUsuario(id) {
                console.log('Buscando o usu&aacute;rio com  id :'+id);
                var deferred = $q.defer();
                $http.get(urls.USER_SERVICE_API + id)
                    .then(
                        function (response) {
                            console.log('Buscando sucesso o usu&aacute;rio com id :'+id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Erro ao carregando o usu&aacute;rio com id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function salvarUsuario(usuario) {
                console.log('Salvando usu&aacute;rio');
                var deferred = $q.defer();
                $http.post(urls.USER_SERVICE_API, usuario)
                    .then(
                        function (response) {
                            loadAllUsers();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                   //        console.error('Erro ao salvar o usuário : '+errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function alterarUsuario(usuario, id) {
                console.log('Atualizando usu&aacute;rio com id '+id);
                var deferred = $q.defer();
                $http.put(urls.USER_SERVICE_API + id, usuario)
                    .then(
                        function (response) {
                            loadAllUsers();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Erro ao atualizar o usu&aacute;rio com id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function excluirUsuario(id) {
                console.log('Excluído o usu&aacute;rio com id'+id);
                var deferred = $q.defer();
                $http.delete(urls.USER_SERVICE_API + id)
                    .then(
                        function (response) {
                            loadAllUsers();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Erro ao excluir o usu&aacute;rio com id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]);