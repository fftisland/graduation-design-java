webpackJsonp([2],{"+skl":function(e,t){},"0S9g":function(e,t){},M93x:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r={render:function(){var e=this.$createElement,t=this._self._c||e;return t("div",{attrs:{id:"app"}},[t("router-view")],1)},staticRenderFns:[]};var u=n("VU/8")({name:"App"},r,!1,function(e){n("0S9g")},null,null);t.default=u.exports},NHnr:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r=n("7+uW"),u=n("M93x"),a=n("/ocq");n("o/zv");r.default.use(a.a);var o=new a.a({scrollBehavior:function(){return{y:0}},routes:[{path:"/",meta:{title:"登录"},redirect:"/login"},{path:"/login",component:function(e){return n.e(0).then(n.bind(null,"UkDw")).then(e)},meta:{title:"登录"}}]});o.beforeEach(function(e,t,n){document.title=e.meta.title||"好的分享应该人尽皆知",n()});var i,l=o,c=n("BTaQ"),p=n.n(c),f=(n("+skl"),n("mtWM")),s=n.n(f);r.default.config.productionTip=!1,r.default.use(p.a),i=r.default,s.a.defaults.timeout=15e3,i.prototype.$http=s.a,new r.default({el:"#app",router:l,components:{App:u.default},template:"<App/>"})}},["NHnr"]);