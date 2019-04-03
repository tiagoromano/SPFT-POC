window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Logout = window.blockly.js.blockly.Logout || {};

/**
 * logout
 */
window.blockly.js.blockly.Logout.logout = function() {
 var item;
  this.cronapi.myfunctions.logout('logout');
}
