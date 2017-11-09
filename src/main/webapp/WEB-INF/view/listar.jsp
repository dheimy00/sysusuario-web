<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead"> Usuário </span></div>
        <div class="panel-body">
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.usuario.id" />
                           <fieldset>                            
                            <div class="row">
                                        <div class="col-md-3">
                                            <div class="form-group col-md-12">	
                                                <label for="txtnome" >Nome:  <span class="obrigatorio">*</span></label>
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                                    <input type="text" class="form-control"  ng-model="ctrl.usuario.nome"   id="txtNome" placeholder="Nome"  style="text-transform:uppercase;" required/>
                                                </div>
                                            </div>
                                        </div>
                                        
                                                <div class="col-md-3">
                                            <div class="form-group col-md-12">	
                                                <label for="txtCPF" >CPF:  <span class="obrigatorio">*</span></label>
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                                    <input type="text" class="form-control" maxlength="14"  ng-model="ctrl.usuario.cpf"   id="txtCPF" placeholder="CPF"  onkeypress="formatar('###.###.###-##', this);" style="text-transform:uppercase;" required/>
                                                </div>
                                            </div>
                                        </div>
                                  </div>
                                  </fieldset>
                                  <br>
                                  <fieldset>
                                    <legend>Endereço</legend>
                                       <div class="row">
                                        <div class="col-md-3">
                                            <div class="form-group col-md-12">	
                                                <label>Numero:<span class="obrigatorio">*</span></label>
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                                                    <input type="text" class="form-control"  ng-model="ctrl.usuario.endereco.numero" placeholder="Numero"  style="text-transform:uppercase;" maxlength="5" required ng-pattern="ctrl.onlyIntegers"/>			  				
                                                </div>	 			 		
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group col-md-12">	
                                                <label>Logradouro:<span class="obrigatorio">*</span></label>
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                                                    <input type="text" class="form-control" name="txtLogradouro"   ng-model="ctrl.usuario.endereco.logradouro" placeholder="Logradouro" style="text-transform:uppercase;" required />			  				
                                                </div>
                                            </div>
                                        </div>                                    
                                        <div class="col-md-3">
                                            <div class="form-group col-md-12">	
                                                <label>Bairro:<span class="obrigatorio">*</span></label>
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                                                    <input type="text" class="form-control" name="txtBairro"  ng-model="ctrl.usuario.endereco.bairro" placeholder="Bairro" style="text-transform:uppercase;" required />			  				
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-3">	 		
                                            <div class="form-group col-md-12">	
                                                <label>CEP:<span class="obrigatorio">*</span></label>
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                                                    <input type="text" class="form-control" name="txtCEP"  ng-model="ctrl.usuario.endereco.cep" placeholder="Cep"  style="text-transform:uppercase;" onkeypress="mascara(this, '#####-###');" maxlength="9"  required ng-pattern="ctrl.onlyIntegers"/>			  				
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                   </fieldset>
                                   <br>
                                    <fieldset>
                                    <legend>Contato</legend>
                                    <div class="row">
                                        <div class="col-md-3">	 		
                                            <div class="form-group col-md-12">	
                                                <label>Telefone:<span class="obrigatorio">*</span></label>
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="glyphicon glyphicon-phone-alt"></i></span>
                                                    <input type="text" class="form-control" ng-model="ctrl.usuario.contato.telefone" placeholder="Telefone"  style="text-transform:uppercase;"  onkeypress="mascara(this, '## ####-####');" maxlength="12" required ng-pattern="ctrl.onlyIntegers"/>			  				
                                                </div>
                                            </div>
                                        </div>

                                        <div class="col-md-3">	 		
                                            <div class="form-group col-md-12">	
                                                <label>Celular:<span class="obrigatorio">*</span></label>
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="glyphicon glyphicon-phone"></i></span>
                                                    <input type="text" class="form-control" ng-model="ctrl.usuario.contato.celular" placeholder="Celular"  style="text-transform:uppercase;" onkeypress="mascara(this, '## ####-####');" maxlength="12" required ng-pattern="ctrl.onlyIntegers"/>			  				
                                                </div>
                                            </div>
                                        </div>                                   
                                        <div class="col-md-4">	 		
                                            <div class="form-group col-md-12">	
                                                <label >Email:<span class="obrigatorio">*</span></label>
                                                <div class="input-group">
                                                    <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                                                    <input type="text" class="form-control" ng-model="ctrl.usuario.contato.email" placeholder="EMAIL"  required/>			  				
                                                    <div class="help-block with-errors"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>                                             
                                </fieldset>                              
                                                               
                    <div class="row">
                        <div class="form-actions floatRight">
                            <input type="submit"  value="{{!ctrl.usuario.id ? 'Salvar' : 'Atualizar'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
                            <button type="button" ng-click="ctrl.reset()" class="btn btn-primary btn-sm" ng-disabled="myForm.$pristine">Limpar</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>    
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Lista de usuários </span></div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>Nome</th>
                        <th>CPF</th>
                        <th>Numero</th> 
                        <th>Logradouro</th>
                        <th>Bairro</th>  
                        <th>CEP</th> 
                        <th>Telefone</th> 
                        <th>Celular</th>             
                        <th>Email</th>                                                
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="u in ctrl.listarUsuario()">
                        <td>{{u.nome}}</td>
                        <td>{{u.cpf}}</td>
                        <td>{{u.endereco.numero}}</td>
                        <td>{{u.endereco.logradouro}}</td>
                        <td>{{u.endereco.bairro}}</td>
                        <td>{{u.endereco.cep}}</td>                             
                        <td>{{u.contato.telefone}}</td>
                        <td>{{u.contato.celular}}</td>     
                        <td>{{u.contato.email}}</td>                        
                        <td><button type="button" ng-click="ctrl.editarUsuario(u.id)" class="btn btn-success custom-width">Editar</button></td>
                        <td><button type="button" ng-click="ctrl.excluirUsuario(u.id)" class="btn btn-danger custom-width">Excluir</button></td>
                    </tr>
                    </tbody>
                </table>      
            </div>
        </div>
    </div>
</div>