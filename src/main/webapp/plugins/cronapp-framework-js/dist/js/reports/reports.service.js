!function(t){angular.module("report.services",[]).service("ReportService",["$http","$compile","$modal","$translate",function(t,e,a,r){var o=$("body"),i=angular.element(o.get(0)).scope(),n=["plugins/cronapp-lib-js/dist/js/stimulsoft/stimulsoft.viewer.css","plugins/cronapp-lib-js/dist/js/stimulsoft/stimulsoft.reports.pack.js","plugins/cronapp-lib-js/dist/js/stimulsoft/stimulsoft.viewer.pack.js","plugins/cronapp-lib-js/dist/js/stimulsoft/stimulsoft-helper.js"],s=[];this.getReport=function(e){var a={url:"api/rest/report",method:"POST",data:angular.toJson({reportName:e})};return t(a)},this.getPDF=function(e){var a={url:"api/rest/report/pdf",method:"POST",responseType:"arraybuffer",data:angular.toJson(e)};return t(a)},this.getPDFAsFile=function(e){var a={url:"api/rest/report/pdfasfile",method:"POST",data:angular.toJson(e)};return t(a)},this.getContentAsString=function(e){var a={url:"api/rest/report/contentasstring",method:"POST",data:angular.toJson(e)};return t(a)},this.getDataSourcesParams=function(e){var a={url:"api/rest/report/getdatasourcesparams",method:"POST",data:angular.toJson(e)};return t(a)},this.openURLContent=function(t){var a=$("#reportViewContext");a.get(0)||(console.log("include[#reportViewContext]"),o.append('<div id="reportViewContext" ng-include="\'plugins/cronapp-framework-js/components/reports/reports.view.html\'"></div>'),e(o)(i));var r=function(){var e=$("<iframe/>");e.attr("frameborder",0);var o=parseInt($(window).height());e.attr("height",o-200),e.attr("width","100%"),e.attr("src",t+"?download=false");var i=$("#reportView .modal-body");i.get(0)?(i.html(e),$("#reportViewContext .modal-dialog").css("width","95%"),setTimeout(function(){console.log("open[#reportViewContext]"),$("body").append(a),$("#reportView").modal()},100)):(console.log("wait[#reportViewContext]"),setTimeout(r,200))};setTimeout(r,200)},this.initializeStimulsoft=function(t){if(!Stimulsoft.Base.StiLicense.Key){stimulsoftHelper.setLanguage(t);var e=stimulsoftHelper.getLocalization();Stimulsoft.Base.Localization.StiLocalization.loadLocalization(e.xml),Stimulsoft.Base.Localization.StiLocalization.cultureName=e.cultureName,Stimulsoft.Base.StiLicense.Key=stimulsoftHelper.getKey()}},this.openStimulsoftReport=function(t,a,r,n){function s(){var t,e,a,r,o,i=setInterval(function(){var n=$("#"+u);n.length?(t||(t=n.parent(),e=t.parent(),a=e.parent(),r=a.parent(),o=r.parent()),"absolute"==n.css("position")&&"absolute"!=e.data("applied")?(e.data("applied","absolute"),e.removeClass("modal-body"),a.removeClass("modal-content"),r.attr("style","top: 0px;right: 0px;bottom: 0px;left: 0px;z-index: 1000000;position: absolute;"),r.removeClass("modal-dialog"),r.removeClass("modal-lg")):"static"==n.css("position")&&"static"!=e.data("applied")&&(e.data("applied","static"),e.addClass("modal-body"),a.addClass("modal-content"),r.attr("style","width:95%"),r.addClass("modal-dialog"),r.addClass("modal-lg"))):(console.log("cleared interval: "+u),clearInterval(i))},100)}var l=$("#reportViewContext");l.get(0)||(o.append('<div id="reportViewContext" ng-include="\'plugins/cronapp-framework-js/components/reports/reports.view.html\'"></div>'),e(o)(i));var p=parseInt($(window).height()),d=p-200+"px",c=new Stimulsoft.Viewer.StiViewerOptions;n?(c.toolbar.visible=n.showToolbar,c.appearance.scrollbarsMode=n.showScrollbar,void 0!=n.height&&(c.height=n.height+"px")):(c.appearance.scrollbarsMode=!0,c.height=d);var u="StiViewer"+app.common.generateId(),m=new Stimulsoft.Viewer.StiViewer(c,u,!1),f=new Stimulsoft.Report.StiReport;if(f.load(t),r||(r=stimulsoftHelper.getDatasourcesInBand(f)),a&&a.forEach(function(t){r.datasources.forEach(function(e){for(var a=0;a<e.fieldParams.length;a++)if(e.fieldParams[a].param==t.originalName){e.fieldParams[a].value=t.value;break}})}),stimulsoftHelper.setParamsInFilter(f.dictionary.dataSources,r.datasources),m.report=f,n&&n.$element)m.renderHtml(n.$element[0]);else var h=setInterval(function(){var t=$("<div/>");t.attr("id","contentReport"),t.attr("width","100%");var e=$("#reportView .modal-body");e.get(0)&&(e.html(t),$("#reportViewContext .modal-dialog").css("width","95%"),setTimeout(function(){console.log("open[#reportViewContext]"),$("body").append(l),$("#reportView").modal(),m.renderHtml("contentReport"),setTimeout(function(){s()},100)},100),clearInterval(h))},200)},this.showParameters=function(t){var e=t.parameters,r=[],o=0,i=function(t){return t.replace(/([.*+?^=!:()|\[\]\/\\])/g,"\\$1")},n=function(t,e,a){return t.replace(new RegExp(i(e),"g"),a)},s=function(){if(o<e.length){var i=e[o++];$.get("plugins/cronapp-framework-js/components/reports/"+i.type+".parameter.html").done(function(t){r.push(n(t,"_field_",i.name)),s()})}else r.length>0&&a.open({templateUrl:"plugins/cronapp-framework-js/components/reports/reports.parameters.html",controller:"ParameterController",resolve:{report:function(){return JSON.parse(JSON.stringify(t))},htmlParameters:function(){return JSON.parse(JSON.stringify(r))}}})}.bind(this);s()},this.mergeParam=function(t,e){for(var a in Object.keys(t)){var r=t[a].name,o=(t[a].value,function(t,e){for(var a in Object.keys(e)){if(t==Object.keys(e[a])[0])return Object.values(e[a])[0]}}(r,e));o&&(t[a].value=o)}return t},this.setVariablesBasedOnParams=function(t,e){for(var a in e){var r=Object.keys(e[a])[0],o=e[a][r];for(var i in t)if(t[i]&&t[i].Name&&t[i].Name===r){t[i].Value=o;break}}},this.hasParameterWithOutValue=function(t){for(var e in Object.keys(t))if(!t[e].value)return!0;return!1},this.getDatasourcesInBand=function(t){var e=new Stimulsoft.Report.StiReport;return e.load(t),stimulsoftHelper.getDatasourcesInBand(e)},this.loadSriptsStimulsoft=function(t){var e=!0,a=n.length,r=0;Pace.options.initialRate=.7,Pace.options.minTime=1750,Pace.options.maxProgressPerFrame=1,Pace.options.ghostTime=12e4,Pace.restart(),n.forEach(function(o,i){this.loadScript(o,function(o){r++,o||(e=!1),r==a&&(Pace.options.initialRate=.03,Pace.options.minTime=250,Pace.options.maxProgressPerFrame=20,Pace.options.ghostTime=10,Pace.stop(),t(e))})}.bind(this))},this.loadScript=function(t,e){if($.inArray(t,s)>=0)return void(e&&e(!0));if(-1!=t.indexOf(".css")){var a=document.createElement("link");a.rel="stylesheet",a.type="text/css",a.href=t,a.media="all",a.onload=function(){s.push(t),e&&e(!0)},a.onerror=function(){e&&e(!1)};try{document.getElementsByTagName("head")[0].appendChild(a)}catch(t){console.log(t)}}else{var r=document.createElement("script");r.type="text/javascript",r.readyState?r.onreadystatechange=function(){"loaded"!=r.readyState&&"complete"!=r.readyState||(r.onreadystatechange=null,s.push(t),e&&e(!0))}:r.onload=function(){s.push(t),e&&e(!0)},r.src=t,document.getElementsByTagName("head")[0].appendChild(r)}},this.openReport=function(t,e,a){this.getReport(t).then(function(t){t&&t.data&&(t.data.reportName.endsWith(".report")?this.loadSriptsStimulsoft(function(o){o?(this.initializeStimulsoft(r.use()),this.getContentAsString(t.data).then(function(o){var i=this.getDatasourcesInBand(o.data);this.getDataSourcesParams(i).then(function(n){i=n.data,t.data.parameters=stimulsoftHelper.parseToGroupedParam(i.datasources),t.data.contentData=o.data,t.data.datasourcesInBand=i,e&&(t.data.parameters=this.mergeParam(t.data.parameters,e),t.data.contentData.Dictionary=t.data.contentData.Dictionary||{},this.setVariablesBasedOnParams(t.data.contentData.Dictionary.Variables,e)),this.hasParameterWithOutValue(t.data.parameters)&&!a?(t.data.parameters.forEach(function(t){t.name=r.instant(t.name)}),this.showParameters(JSON.parse(JSON.stringify(t.data)))):this.openStimulsoftReport(o.data,t.data.parameters,t.data.datasourcesInBand,a)}.bind(this))}.bind(this),function(t){var e=cronapi.internal.getErrorMessage(t,t.statusText);i.Notification.error(e)}.bind(this))):i.Notification.error("Error loading report script")}.bind(this)):0==t.data.parameters.length||1==t.data.parameters.length&&"DATA_LIMIT"==t.data.parameters[0].name?this.getPDFAsFile(t.data.reportName).then(function(t){this.openURLContent(t.data)}.bind(this),function(t){var e=cronapi.internal.getErrorMessage(t,t.statusText);i.Notification.error(e)}.bind(this)):(e&&(t.data.parameters=this.mergeParam(t.data.parameters,e)),this.hasParameterWithOutValue(t.data.parameters)?this.showParameters(JSON.parse(JSON.stringify(t.data))):this.getPDFAsFile(t.data).then(function(t){this.openURLContent(t.data)}.bind(this))))}.bind(this))}}])}(app);