window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Logout = window.blockly.js.blockly.Logout || {};

/**
 * logout
 */
window.blockly.js.blockly.Logout.logout = function() {
 var item;
  this.cronapi.util.getURLFromOthers('GET', 'application/x-www-form-urlencoded', 'https://s6006as2390.transp.biz:9443/commonauth?commonAuthLogout=true&amp;type=oid&amp;commonAuthCallerPath=http://s6006as2391.transp.biz:8889/logout', null, null, function(sender_item) {
      item = sender_item;
    this.cronapi.screen.logout();
  }.bind(this), function(sender_item) {
      item = sender_item;
    this.cronapi.screen.logout();
  }.bind(this));
}
