"use strict";(self["webpackChunkpaike_sut"]=self["webpackChunkpaike_sut"]||[]).push([[278],{7278:function(e,o,s){s.r(o),s.d(o,{default:function(){return b}});s(2064),s(6809),s(4566),s(7113),s(172),s(8474);var a=s(7188),t=s(1267),n=s(9805),r=s(3060),l=s(1015),i=s(3396),d=s(9242);const u=e=>((0,i.dD)("data-v-07dbfb97"),e=e(),(0,i.Cn)(),e),p={class:"login-container"},c=u((()=>(0,i._)("head",null,[(0,i._)("meta",{name:"viewport",content:"width=device-width,initial-scale=1.0"})],-1))),m=u((()=>(0,i._)("div",{class:"title-container"},[(0,i._)("h3",{class:"title"},"实验室管理系统")],-1))),w={class:"svg-container"},h={class:"svg-container"},g=(0,i.Uk)("登陆");function f(e,o,s,u,f,y){const k=(0,i.up)("i-user"),_=l.gn,v=r.EZ,T=a.nH,b=(0,i.up)("i-lock"),F=(0,i.up)("i-view"),W=n.Q0,C=t.mi,V=a.ly;return(0,i.wg)(),(0,i.iD)("div",p,[c,(0,i.Wm)(V,{ref:"loginForm",model:f.loginForm,rules:f.loginRules,class:"login-form",autocomplete:"on","label-position":"left"},{default:(0,i.w5)((()=>[m,(0,i.Wm)(T,{prop:"username"},{default:(0,i.w5)((()=>[(0,i._)("span",w,[(0,i.Wm)(_,null,{default:(0,i.w5)((()=>[(0,i.Wm)(k)])),_:1})]),(0,i.Wm)(v,{ref:"username",modelValue:f.loginForm.username,"onUpdate:modelValue":o[0]||(o[0]=e=>f.loginForm.username=e),placeholder:"Username",name:"username",type:"text",tabindex:"1",autocomplete:"on"},null,8,["modelValue"])])),_:1}),(0,i.Wm)(W,{modelValue:f.capsTooltip,"onUpdate:modelValue":o[4]||(o[4]=e=>f.capsTooltip=e),content:"查看密码",placement:"right",manual:""},{default:(0,i.w5)((()=>[(0,i.Wm)(T,{prop:"password"},{default:(0,i.w5)((()=>[(0,i._)("span",h,[(0,i.Wm)(_,null,{default:(0,i.w5)((()=>[(0,i.Wm)(b)])),_:1})]),((0,i.wg)(),(0,i.j4)(v,{key:f.passwordType,ref:"password",modelValue:f.loginForm.password,"onUpdate:modelValue":o[1]||(o[1]=e=>f.loginForm.password=e),type:f.passwordType,placeholder:"Password",name:"password",tabindex:"2",autocomplete:"on",onKeyup:[(0,d.D2)(y.checkCapslock,["native"]),(0,d.D2)(y.handleLogin,["enter","native"])],onBlur:o[2]||(o[2]=e=>f.capsTooltip=!1)},null,8,["modelValue","type","onKeyup"])),(0,i._)("span",{class:"show-pwd",onClick:o[3]||(o[3]=(...e)=>y.showPwd&&y.showPwd(...e))},[(0,i.Wm)(_,{"icon-class":"password"===f.passwordType?"eye":"eye-open"},{default:(0,i.w5)((()=>[(0,i.Wm)(F)])),_:1},8,["icon-class"])])])),_:1})])),_:1},8,["modelValue"]),(0,i.Wm)(C,{loading:f.loading,type:"primary",style:{width:"100%","margin-bottom":"30px"},onClick:(0,d.iM)(y.handleLogin,["prevent"])},{default:(0,i.w5)((()=>[g])),_:1},8,["loading","onClick"])])),_:1},8,["model","rules"])])}var y=s(5574),k=(s(7233),s(1703),s(2826)),_=(s(8192),{name:"Login",data(){const e=(e,o,s)=>{(0,k.CI)(o)?s():s(new Error("请输入正确的用户名"))},o=(e,o,s)=>{0==o.length?s(new Error("请输入正确的密码")):s()};return{loginType:1,loginForm:{username:"admin",password:"admin"},loginRules:{username:[{required:!0,trigger:"blur",validator:e}],password:[{required:!0,trigger:"blur",validator:o}]},passwordType:"password",capsTooltip:!1,loading:!1,showDialog:!1,redirect:void 0,otherQuery:{}}},mounted(){""===this.loginForm.username?this.$refs.username.focus():""===this.loginForm.password&&this.$refs.password.focus(),document.title="登陆"},methods:{checkCapslock(e){const{key:o}=e;this.capsTooltip=o&&1===o.length&&o>="A"&&o<="Z"},showPwd(){"password"===this.passwordType?this.passwordType="":this.passwordType="password",this.$nextTick((()=>{this.$refs.password.focus()}))},handleLogin(){this.$refs.loginForm.validate((e=>{if(!e)return console.log("error submit!!"),!1;{const e=this;this.loading=!0,this.$axios.post("/login",this.loginForm).then((o=>{const s=o.data;if(200==s.code){const s=o.data;o.headers["authorization"];localStorage.setItem("token",o.headers["authorization"]),e.$store.commit("SET_USERINFO",s.data),y.z8.success(s.msg),window.location.href="/"}else y.z8.error(s.msg)})).catch((e=>{this.loading=!1}))}}))},getOtherQuery(e){return Object.keys(e).reduce(((o,s)=>("redirect"!==s&&(o[s]=e[s]),o)),{})}}}),v=s(89);const T=(0,v.Z)(_,[["render",f],["__scopeId","data-v-07dbfb97"]]);var b=T},6809:function(e,o,s){s(1758)},7113:function(e,o,s){s(1758)},2064:function(e,o,s){s(1758)},172:function(e,o,s){s(1758)}}]);
//# sourceMappingURL=278.448878bb.js.map