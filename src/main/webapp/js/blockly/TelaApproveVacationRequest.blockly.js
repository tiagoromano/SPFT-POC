window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.TelaApproveVacationRequest = window.blockly.js.blockly.TelaApproveVacationRequest || {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.TelaApproveVacationRequest.ReprovarSolicitacoesComJustificativa = function() {
 var item, totalSolicitacao, justificativa, selectedRows;
  selectedRows = this.cronapi.screen.getSelectedRowsGrid("vars.gradeAprovarMarcacaoFerias");
  totalSolicitacao = selectedRows.length;
  justificativa = this.cronapi.screen.getValueOfField("vars.justificativaReprovacao");
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.Ferias:ReprovarSolicitacaoFerias', function(sender_item) {
      item = sender_item;
    if (this.cronapi.logic.isNullOrEmpty(item) || item == 0) {
      this.cronapi.screen.notify('error','Não foi possível reprovar a(s) solicitação(ões) selecionada(s)');
    } else {
      this.cronapi.screen.notify('success',['Foi(ram) reprovada(s)  ',item,' de ',totalSolicitacao,' solicitação(ções)'].join(''));
      this.cronapi.screen.hideModal("modalJustReprov");
      this.cronapi.screen.refreshDatasource(eval("ObterSolicitacaoDeFeriasPorOrgaoEStatus"), 'true');
    }
  }.bind(this), selectedRows, justificativa);
}

/**
 * TelaApproveVacationRequest
 */
window.blockly.js.blockly.TelaApproveVacationRequest.ReprovarSolicitacoes = function(selectedRows) {
 var item, totalSolicitacao, justificativa;
  item = selectedRows.length;
  if (item == 0) {
    this.cronapi.screen.notify('error','Selecione alguma solicitação para aprovar');
  } else {
    this.cronapi.screen.changeValueOfField("vars.justificativaReprovacao", '');
    this.cronapi.screen.showModal("modalJustReprov");
  }
}
