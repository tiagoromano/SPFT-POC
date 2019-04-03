(function() {
  'use strict';

  this.cronapi = this.cronapi || {};

   /**
   * @categoryName logout
   */
  this.cronapi.myfunctions = {};
  
  /**
   * @type function
   * @name logout
   * @description logout
   * @multilayer false
   * @param {ObjectType.STRING} input Param Description
   * @returns {ObjectType.STRING}
   */
  this.cronapi.myfunctions.logout = function(/** @type {ObjectType.STRING} @description Parâmetro: Descrição do parâmetro */id) {
    localStorage.removeItem("_u");
   this.cronapi.$scope.safeApply( ()=> document[id].submit());
  };
  

}).bind(window)();