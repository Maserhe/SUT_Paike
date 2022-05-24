"use strict";(self["webpackChunkpaike_sut"]=self["webpackChunkpaike_sut"]||[]).push([[880],{6966:function(e,s,t){t.r(s),t.d(s,{default:function(){return F}});t(7437),t(9910),t(877),t(7579),t(8474),t(6905),t(3069),t(172),t(9007),t(451),t(6809),t(6512),t(3877),t(7960),t(7219);var i=t(4143),l=t(4827),a=t(1832),n=t(1015),o=t(3209),r=t(426),d=t(3060),u=t(6739),h=t(1267),c=t(8435),p=t(7927),m=t(1244),y=t(3396),g=t(7139),f=t(9242);const w=e=>((0,y.dD)("data-v-09208b60"),e=e(),(0,y.Cn)(),e),b=w((()=>(0,y._)("h4",null,"申请实验室报修",-1))),S=w((()=>(0,y._)("br",null,null,-1))),z={style:{display:"flex","align-items":"center"}},x=w((()=>(0,y._)("p",{style:{"margin-right":"1rem"}},"学院",-1))),_=w((()=>(0,y._)("p",{style:{"margin-right":"1rem"}},"实验室",-1))),W=(0,y.Uk)("非设备报修"),k=(0,y.Uk)("设备报修"),C=(0,y.Uk)("学院"),V=(0,y.Uk)("实验室"),v=(0,y.Uk)("设备"),L=w((()=>(0,y._)("br",null,null,-1))),U={style:{display:"flex","align-items":"center"}},Y=w((()=>(0,y._)("span",null,"故障信息",-1))),I=w((()=>(0,y._)("br",null,null,-1))),O={style:{"text-align":"center"}},R=(0,y.Uk)("确定"),D=(0,y.Uk)("学院"),B=(0,y.Uk)("实验室门牌号"),J=(0,y.Uk)("实验室类型"),N=w((()=>(0,y._)("br",null,null,-1))),$={style:{display:"flex","align-items":"center"}},j=w((()=>(0,y._)("span",null,"故障信息",-1))),H=w((()=>(0,y._)("br",null,null,-1))),P={style:{"text-align":"center"}},T=(0,y.Uk)("确定");function M(e,s,t,w,M,K){const Q=m.os,Z=p.BT,q=p.km,A=c.m,E=h.mi,F=u.Mr,G=o.$Y,X=d.EZ,ee=r.R,se=o.eI,te=(0,y.up)("i-tickets"),ie=n.gn,le=a.QQ,ae=(0,y.up)("i-location-information"),ne=(0,y.up)("i-timer"),oe=a.Lf,re=l.d0,de=i.Kf;return(0,y.wg)(),(0,y.j4)(de,{class:"account-container"},{default:(0,y.w5)((()=>[b,(0,y.Wm)(Q),S,(0,y.Wm)(F,{always:!0},{default:(0,y.w5)((()=>[(0,y._)("div",z,[x,(0,y.Wm)(q,{modelValue:w.YxsOption,"onUpdate:modelValue":s[0]||(s[0]=e=>w.YxsOption=e),placeholder:"选择学院",onChange:K.changeYxs,style:{"margin-right":"1rem"}},{default:(0,y.w5)((()=>[((0,y.wg)(!0),(0,y.iD)(y.HY,null,(0,y.Ko)(M.YxsList,((e,s)=>((0,y.wg)(),(0,y.j4)(Z,{key:s,label:e.dwmc,value:e},null,8,["label","value"])))),128))])),_:1},8,["modelValue","onChange"]),_,(0,y.Wm)(A,{placeholder:"选择实验室",modelValue:w.SysCascaderOption,"onUpdate:modelValue":s[1]||(s[1]=e=>w.SysCascaderOption=e),options:K.getSysCascader,onChange:K.changeCascader,style:{"margin-right":"1rem"},filterable:""},null,8,["modelValue","options","onChange"]),(0,y.Wm)(E,{type:"danger",onClick:K.applySysRepair},{default:(0,y.w5)((()=>[W])),_:1},8,["onClick"])])])),_:1}),(0,y.Wm)(se,{data:K.sbTableInfo.slice((M.currentPage-1)*M.pagesize,M.currentPage*M.pagesize),style:{width:"100%"}},{append:(0,y.w5)((()=>[(0,y.Wm)(ee,{onSizeChange:K.handleSizeChange,onCurrentChange:K.handleCurrentChange,"current-page":M.currentPage,"page-sizes":[5,10,20,40],"page-size":M.pagesize,layout:"total, sizes, prev, pager, next, jumper",total:K.sbTableInfo.length},null,8,["onSizeChange","onCurrentChange","current-page","page-size","total"])])),default:(0,y.w5)((()=>[(0,y.Wm)(G,{type:"index"}),(0,y.Wm)(G,{label:"设备名称",prop:"sbmc",width:"220rem"}),(0,y.Wm)(G,{label:"设备状态",prop:"state",width:"220rem"}),(0,y.Wm)(G,{label:"故障信息",prop:"info",width:"220rem"}),(0,y.Wm)(G,{label:"设备报修",width:"300rem"},{header:(0,y.w5)((()=>[(0,y.Wm)(X,{modelValue:M.search,"onUpdate:modelValue":s[2]||(s[2]=e=>M.search=e),placeholder:"输入设备名称搜索"},null,8,["modelValue"])])),default:(0,y.w5)((e=>[0==e.row.sbzt?((0,y.wg)(),(0,y.j4)(E,{key:0,type:"danger",onClick:s=>K.applyRepair(e.row),text:""},{default:(0,y.w5)((()=>[k])),_:2},1032,["onClick"])):(0,y.kq)("",!0)])),_:1})])),_:1},8,["data"]),(0,y.Wm)(re,{modelValue:w.repairDialogVisible,"onUpdate:modelValue":s[5]||(s[5]=e=>w.repairDialogVisible=e),title:"申请设备报修",width:"40%","before-close":w.handleClose},{default:(0,y.w5)((()=>[(0,y.Wm)(oe,{column:1,border:""},{default:(0,y.w5)((()=>[(0,y.Wm)(le,null,{label:(0,y.w5)((()=>[(0,y.Wm)(ie,null,{default:(0,y.w5)((()=>[(0,y.Wm)(te)])),_:1}),C])),default:(0,y.w5)((()=>[(0,y.Uk)((0,g.zw)(M.Yxs.dwmc),1)])),_:1}),(0,y.Wm)(le,null,{label:(0,y.w5)((()=>[(0,y.Wm)(ie,null,{default:(0,y.w5)((()=>[(0,y.Wm)(ae)])),_:1}),V])),default:(0,y.w5)((()=>[(0,y.Uk)((0,g.zw)(M.Sys.sysmph)+" "+(0,g.zw)(M.Sys.sysmc),1)])),_:1}),(0,y.Wm)(le,null,{label:(0,y.w5)((()=>[(0,y.Wm)(ie,null,{default:(0,y.w5)((()=>[(0,y.Wm)(ne)])),_:1}),v])),default:(0,y.w5)((()=>[(0,y.Uk)(" "+(0,g.zw)(M.Sb.sbmc),1)])),_:1})])),_:1}),(0,y.Wm)(Q),L,(0,y._)("div",U,[Y,(0,y.Wm)(X,{style:{"margin-right":"1rem"},modelValue:M.SbgzInfo,"onUpdate:modelValue":s[3]||(s[3]=e=>M.SbgzInfo=e),autosize:{minRows:2,maxRows:4},type:"textarea",placeholder:"必需输入"},null,8,["modelValue"])]),I,(0,y._)("div",O,[(0,y.Wm)(E,{size:"large",type:"primary",style:{width:"6rem"},onClick:s[4]||(s[4]=(0,f.iM)((e=>K.applyRepairButton()),["prevent"]))},{default:(0,y.w5)((()=>[R])),_:1})])])),_:1},8,["modelValue","before-close"]),(0,y.Wm)(re,{modelValue:w.repairSysDialogVisible,"onUpdate:modelValue":s[8]||(s[8]=e=>w.repairSysDialogVisible=e),title:"申请实验室报修",width:"40%","before-close":w.handleClose},{default:(0,y.w5)((()=>[(0,y.Wm)(oe,{column:1,border:""},{default:(0,y.w5)((()=>[(0,y.Wm)(le,null,{label:(0,y.w5)((()=>[(0,y.Wm)(ie,null,{default:(0,y.w5)((()=>[(0,y.Wm)(te)])),_:1}),D])),default:(0,y.w5)((()=>[(0,y.Uk)((0,g.zw)(M.Yxs.dwmc),1)])),_:1}),(0,y.Wm)(le,null,{label:(0,y.w5)((()=>[(0,y.Wm)(ie,null,{default:(0,y.w5)((()=>[(0,y.Wm)(ae)])),_:1}),B])),default:(0,y.w5)((()=>[(0,y.Uk)((0,g.zw)(M.Sys.sysmph),1)])),_:1}),(0,y.Wm)(le,null,{label:(0,y.w5)((()=>[(0,y.Wm)(ie,null,{default:(0,y.w5)((()=>[(0,y.Wm)(ne)])),_:1}),J])),default:(0,y.w5)((()=>[(0,y.Uk)(" "+(0,g.zw)(M.Sys.sysmc),1)])),_:1})])),_:1}),N,(0,y._)("div",$,[j,(0,y.Wm)(X,{style:{"margin-right":"1rem"},modelValue:M.SysgzInfo,"onUpdate:modelValue":s[6]||(s[6]=e=>M.SysgzInfo=e),autosize:{minRows:2,maxRows:4},type:"textarea",placeholder:"必需输入"},null,8,["modelValue"])]),H,(0,y._)("div",P,[(0,y.Wm)(E,{size:"large",type:"primary",style:{width:"6rem"},onClick:s[7]||(s[7]=(0,f.iM)((e=>K.sysRepairButton()),["prevent"]))},{default:(0,y.w5)((()=>[T])),_:1})])])),_:1},8,["modelValue","before-close"])])),_:1})}var K=t(1897),Q=t(5574),Z=(t(3970),t(7233),t(4870)),q={setup(){const e=(0,Z.iH)(""),s=(0,Z.iH)([]),t=(0,Z.iH)(!1),i=(0,Z.iH)(!1),l=e=>{K.T.confirm("确定关闭对话框?","温馨提示",{type:"info",center:!0}).then((()=>{e()}))};return{YxsOption:e,SysCascaderOption:s,repairDialogVisible:t,handleClose:l,repairSysDialogVisible:i}},data(){return{currentPage:1,pagesize:10,search:"",YxsList:[],Yxs:{},SysList:[],Sys:{},sbList:[],Sb:{},SbgzInfo:"",SysgzInfo:""}},created(){this.getYxsList()},methods:{handleSizeChange:function(e){this.pagesize=e},handleCurrentChange:function(e){this.currentPage=e},getYxsList(){this.$axios.get("/weixin-yxs/getAllYxs").then((e=>{const s=e.data;200==s.code&&(this.YxsList=s.data)}))},devicelist(e){this.$axios.post("/weixin-sbzk/deviceList",{sysh:e}).then((e=>{const s=e.data;200==s.code?this.sbList=s.data:Q.z8.error("获取设备列表失败")}))},getSysListById(e){this.$axios.get("/weixin-syszk/getById?id="+e).then((e=>{const s=e.data;200==s.code&&(this.SysList=s.data)}))},changeYxs(){this.Yxs=JSON.parse(JSON.stringify(this.YxsOption)),this.YxsOption=this.Yxs.dwmc,this.SysCascaderOption="",Loading.show(),this.getSysListById(this.Yxs.dwh),Loading.hide()},changeCascader(e){this.Sys=JSON.parse(JSON.stringify(this.SysList.find((s=>s.sysh==e[1])))),Loading.show(),this.devicelist(this.Sys.sysh),Loading.hide()},applyRepair(e){this.Sb=JSON.parse(JSON.stringify(e)),this.repairDialogVisible=!0},applyRepairButton(){""!=this.SbgzInfo?this.$axios.post("/weixin-sbzk/repairSb",{sbh:this.Sb.sbh,info:this.SbgzInfo,sbzt:"2",sysh:this.Sys.sysh}).then((e=>{const s=e.data;200==s.code&&(Q.z8.success("申请成功"),this.devicelist(this.Sys.sysh),this.SbgzInfo="",this.repairDialogVisible=!1)})):Q.z8.error("填写故障信息")},applySysRepair(){0==Object.keys(this.Sys).length?Q.z8.error("请先选择实验室"):(console.log(this.Sys),"1"==this.Sys.systype?Q.z8.error("该实验室已经被禁用"):null!=this.Sys.info&&""!=this.Sys.info?Q.z8.error("该实验室已经申请过了报修"):this.repairSysDialogVisible=!0)},sysRepairButton(){""!=this.SysgzInfo?this.$axios.post("/weixin-syszk/repairSys",{sysh:this.Sys.sysh,systype:"2",info:this.SysgzInfo}).then((e=>{const s=e.data;200==s.code&&(Q.z8.success("报修申请提交成功"),this.repairSysDialogVisible=!1,this.SysCascaderOption=[],Loading.show(),this.getSysListById(this.Yxs.dwh),Loading.hide())})).catch((e=>{Q.z8.error(e)})):Q.z8.error("填写故障信息")}},computed:{getSysCascader(){let e=[];var s=new Map;return this.SysList.map((t=>{if(s.has(t.sysmc)){var i=s.get(t.sysmc);i.children.push({value:t.sysh,label:t.sysmph})}else{i={};i.value=t.yxsh,i.label=t.sysmc,i.children=[{value:t.sysh,label:t.sysmph}],s.set(t.sysmc,i),e.push(i)}})),e},sbTableInfo(){return this.sbList.map((e=>(0==e.sbzt?e["state"]="开放":1==e.sbzt?e["state"]="禁用":e["state"]="报修",e))).filter((e=>!this.search||e.sbmc.includes(this.search.toLowerCase())))}}},A=t(89);const E=(0,A.Z)(q,[["render",M],["__scopeId","data-v-09208b60"]]);var F=E},6809:function(e,s,t){t(1758)},7437:function(e,s,t){t(1758)},6512:function(e,s,t){t(1758),t(172),t(6467),t(1430),t(88),t(3429),t(451)},88:function(e,s,t){t(1758)},7579:function(e,s,t){t(1758)},877:function(e,s,t){t(1758),t(7579)},9910:function(e,s,t){t(1758),t(7195)},7219:function(e,s,t){t(1758)},172:function(e,s,t){t(1758)},3970:function(e,s,t){t(1758),t(6809),t(172),t(7195)},7960:function(e,s,t){t(1758)},7195:function(e,s,t){t(1758)},3069:function(e,s,t){t(1758),t(3877)},3429:function(e,s,t){t(1758)},451:function(e,s,t){t(1758)},3877:function(e,s,t){t(1758),t(172),t(1430),t(7960),t(451),t(6467)},9007:function(e,s,t){t(1758),t(88),t(1430)},6905:function(e,s,t){t(1758),t(88),t(1430),t(4566),t(451)}}]);
//# sourceMappingURL=880.52b48e5d.js.map