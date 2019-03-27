window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.approveVacationRequest = window.blockly.js.blockly.approveVacationRequest || {};
window.blockly.js.blockly.approveVacationRequest.ApproveAdapter = window.blockly.js.blockly.approveVacationRequest.ApproveAdapter || {};

/**
 * ApproveAdapter
 */
window.blockly.js.blockly.approveVacationRequest.ApproveAdapter.approve = function(item) {

  this.cronapi.util.callServerBlocklyNoReturn('blockly.TelaApproveVacationRequest:AprovarSolicitacoes', [item]);
}
