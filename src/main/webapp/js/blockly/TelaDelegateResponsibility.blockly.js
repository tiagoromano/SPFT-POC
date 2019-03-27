window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.TelaDelegateResponsibility = window.blockly.js.blockly.TelaDelegateResponsibility || {};

/**
 * TelaDelegateResponsibility
 */
window.blockly.js.blockly.TelaDelegateResponsibility.Incluir = function() {
 var item, orgaoLista;
  orgaoLista = this.cronapi.screen.getSelectedRowsGrid("vars.gerenciasGrade");
  if (orgaoLista.length == 0) {
    this.cronapi.screen.notify('error','Selecione as gerências que deseja delegar');
  } else if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.nome"))) {
    this.cronapi.screen.notify('error','Informe uma chave valida do funcionário');
  } else if (this.cronapi.logic.isNullOrEmpty(this.cronapi.screen.getValueOfField("vars.tipoDelegacao"))) {
    this.cronapi.screen.notify('error','Informe o tipo de delegação');
  } else {
    this.cronapi.util.callServerBlocklyAsynchronous('blockly.TelaDelegateResponsibility:IncluirDelegacao', function(sender_item) {
        item = sender_item;
    }.bind(this), this.cronapi.screen.getValueOfField("vars.chave"), this.cronapi.screen.getValueOfField("vars.tipoDelegacao"), orgaoLista);
  }
}
