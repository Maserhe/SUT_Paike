"use strict";(self["webpackChunkpaike_sut"]=self["webpackChunkpaike_sut"]||[]).push([[919],{7919:function(e,s,t){t.r(s),t.d(s,{default:function(){return de}});t(7437),t(7500),t(9910),t(33),t(6226),t(877),t(7579),t(8474),t(2064),t(2942),t(3429),t(7113),t(6905),t(3069),t(3855),t(172),t(9007),t(6809),t(7219);var a=t(4143),l=t(9523),d=t(4827),o=t(1853),i=t(1832),n=t(1015),m=t(7188),u=t(3732),f=t(3209),c=t(426),y=t(2563),r=t(3060),p=t(1267),h=t(1244),b=t(3396),w=t(7139);const S=e=>((0,b.dD)("data-v-f5d04436"),e=e(),(0,b.Cn)(),e),I=S((()=>(0,b._)("h4",null,"实验室管理",-1))),g=S((()=>(0,b._)("br",null,null,-1))),W=(0,b.Uk)("添加实验室"),_=S((()=>(0,b._)("br",null,null,-1))),k=(0,b.Uk)("管理"),V=(0,b.Uk)("删除"),x=(0,b.Uk)("开放"),C=(0,b.Uk)("禁用"),z={style:{margin:"0 auto"}},U=(0,b.Uk)("更新"),v=(0,b.Uk)("重置"),L=(0,b.Uk)("学院"),D=(0,b.Uk)("实验室门牌号"),Y=(0,b.Uk)("实验室类型"),q=(0,b.Uk)("故障"),$=(0,b.Uk)(" 该实验室有故障报修申请，不允许修改操作 "),B=(0,b.Uk)("删除"),F=(0,b.Uk)("正常"),N=(0,b.Uk)("故障"),R={style:{margin:"0 auto"}},T=(0,b.Uk)("添加"),A=(0,b.Uk)("重置"),H=(0,b.Uk)("开放"),P=(0,b.Uk)("禁用"),j={style:{margin:"0 auto"}},J=(0,b.Uk)("添加"),M=(0,b.Uk)("重置"),O={style:{"text-align":"center"}},K=S((()=>(0,b._)("div",{class:"el-upload__text"},[(0,b.Uk)("拖拽文件到这或者"),(0,b._)("em",null,"点击上传")],-1))),Q=S((()=>(0,b._)("div",{class:"el-upload__tip"},"需要上传指定格式的csv文件,请先下载模版,仿照着写",-1))),Z=S((()=>(0,b._)("a",{href:"/addLabs.csv",download:"addLabs.csv"},"模版下载",-1)));function E(e,s,t,S,E,G){const X=h.os,ee=p.mi,se=f.$Y,te=r.EZ,ae=y.i1,le=c.R,de=f.eI,oe=m.nH,ie=u.rh,ne=u.KD,me=m.ly,ue=(0,b.up)("i-tickets"),fe=n.gn,ce=i.QQ,ye=(0,b.up)("i-location-information"),re=(0,b.up)("i-timer"),pe=(0,b.up)("i-remove-filled"),he=i.Lf,be=o.p8,we=o.Ub,Se=d.d0,Ie=(0,b.up)("i-upload-filled"),ge=l.LW,We=a.Kf;return(0,b.wg)(),(0,b.j4)(We,{class:"account-container"},{default:(0,b.w5)((()=>[I,(0,b.Wm)(X),g,(0,b.Wm)(ee,{type:"primary",style:{display:"inline-block"},onClick:G.addSysDialog},{default:(0,b.w5)((()=>[W])),_:1},8,["onClick"]),_,(0,b.Wm)(de,{data:G.getSysFilter.slice((E.currentPage-1)*E.pagesize,E.currentPage*E.pagesize),style:{width:"100%"}},{append:(0,b.w5)((()=>[(0,b.Wm)(le,{onSizeChange:G.handleSizeChange,onCurrentChange:G.handleCurrentChange,"current-page":E.currentPage,"page-sizes":[5,10,20,40],"page-size":E.pagesize,layout:"total, sizes, prev, pager, next, jumper",total:G.getSysFilter.length},null,8,["onSizeChange","onCurrentChange","current-page","page-size","total"])])),default:(0,b.w5)((()=>[(0,b.Wm)(se,{type:"index"}),(0,b.Wm)(se,{label:"实验名称",prop:"sysmc",width:"220rem"}),(0,b.Wm)(se,{label:"门牌号",prop:"sysmph"}),(0,b.Wm)(se,{label:"容量",prop:"capacity"}),(0,b.Wm)(se,{label:"状态",prop:"state"}),(0,b.Wm)(se,{label:"操作",width:"300rem"},{header:(0,b.w5)((()=>[(0,b.Wm)(te,{modelValue:E.search,"onUpdate:modelValue":s[0]||(s[0]=e=>E.search=e),placeholder:"输入实验室门牌号、名称、状态过滤"},null,8,["modelValue"])])),default:(0,b.w5)((e=>[(0,b.Wm)(ee,{type:"primary",onClick:s=>G.changeSysInfo(e.row)},{default:(0,b.w5)((()=>[k])),_:2},1032,["onClick"]),(0,b.Wm)(ae,{title:"确定要删除该实验室?",onConfirm:s=>G.deleteSysById(e.row.sysh)},{reference:(0,b.w5)((()=>[(0,b.Wm)(ee,{type:"danger"},{default:(0,b.w5)((()=>[V])),_:1})])),_:2},1032,["onConfirm"])])),_:1})])),_:1},8,["data"]),(0,b.Wm)(Se,{modelValue:S.dialogVisible,"onUpdate:modelValue":s[12]||(s[12]=e=>S.dialogVisible=e),title:"实验室管理",width:"60%","before-close":S.handleClose},{default:(0,b.w5)((()=>[(0,b.Wm)(we,{onTabClick:G.tabsClick,modelValue:S.manageActiveName,"onUpdate:modelValue":s[11]||(s[11]=e=>S.manageActiveName=e)},{default:(0,b.w5)((()=>[(0,b.Wm)(be,{label:"修改实验室信息",name:"first"},{default:(0,b.w5)((()=>[2!=E.SysInfo.systype?((0,b.wg)(),(0,b.j4)(me,{key:0,ref:"sysInfoRef",model:E.SysInfo,"label-position":"left",class:"sys-form"},{default:(0,b.w5)((()=>[(0,b.Wm)(oe,{label:"实验室的名称",prop:"sysmc",rules:[{required:!0,message:"必需填写,例如: 人工智能实验室, 例如: 机房"}]},{default:(0,b.w5)((()=>[(0,b.Wm)(te,{modelValue:E.SysInfo.sysmc,"onUpdate:modelValue":s[1]||(s[1]=e=>E.SysInfo.sysmc=e),type:"text",autocomplete:"off"},null,8,["modelValue"])])),_:1}),(0,b.Wm)(oe,{label:"实验室门牌号",prop:"sysmph",rules:[{required:!0,message:"必需填写,表示实验室位置,例如: 205"}]},{default:(0,b.w5)((()=>[(0,b.Wm)(te,{modelValue:E.SysInfo.sysmph,"onUpdate:modelValue":s[2]||(s[2]=e=>E.SysInfo.sysmph=e),type:"text",autocomplete:"off"},null,8,["modelValue"])])),_:1}),(0,b.Wm)(oe,{label:"实验室的容量",prop:"capacity",rules:[{required:!0,message:"必需填写,实验室的人数,例如: 40"}]},{default:(0,b.w5)((()=>[(0,b.Wm)(te,{modelValue:E.SysInfo.capacity,"onUpdate:modelValue":s[3]||(s[3]=e=>E.SysInfo.capacity=e),type:"number",min:"0",autocomplete:"off"},null,8,["modelValue"])])),_:1}),(0,b.Wm)(oe,{label:"实验室的类型",rules:[{required:!0,message:"必需选择，默认开放"}]},{default:(0,b.w5)((()=>[(0,b.Wm)(ne,{modelValue:E.SysInfo.systype,"onUpdate:modelValue":s[4]||(s[4]=e=>E.SysInfo.systype=e)},{default:(0,b.w5)((()=>[(0,b.Wm)(ie,{label:"0"},{default:(0,b.w5)((()=>[x])),_:1}),(0,b.Wm)(ie,{label:"1"},{default:(0,b.w5)((()=>[C])),_:1})])),_:1},8,["modelValue"])])),_:1}),(0,b.Wm)(oe,null,{default:(0,b.w5)((()=>[(0,b._)("div",z,[(0,b.Wm)(ee,{type:"primary",onClick:s[5]||(s[5]=e=>G.updateSysInfo("sysInfoRef"))},{default:(0,b.w5)((()=>[U])),_:1}),(0,b.Wm)(ee,{onClick:s[6]||(s[6]=e=>G.resetForm("sysInfoRef"))},{default:(0,b.w5)((()=>[v])),_:1})])])),_:1})])),_:1},8,["model"])):(0,b.kq)("",!0),2==E.SysInfo.systype?((0,b.wg)(),(0,b.j4)(he,{key:1,column:1,border:""},{default:(0,b.w5)((()=>[(0,b.Wm)(ce,null,{label:(0,b.w5)((()=>[(0,b.Wm)(fe,null,{default:(0,b.w5)((()=>[(0,b.Wm)(ue)])),_:1}),L])),default:(0,b.w5)((()=>[(0,b.Uk)((0,w.zw)(E.Yxs.dwmc),1)])),_:1}),(0,b.Wm)(ce,null,{label:(0,b.w5)((()=>[(0,b.Wm)(fe,null,{default:(0,b.w5)((()=>[(0,b.Wm)(ye)])),_:1}),D])),default:(0,b.w5)((()=>[(0,b.Uk)((0,w.zw)(E.SysInfo.sysmph),1)])),_:1}),(0,b.Wm)(ce,null,{label:(0,b.w5)((()=>[(0,b.Wm)(fe,null,{default:(0,b.w5)((()=>[(0,b.Wm)(re)])),_:1}),Y])),default:(0,b.w5)((()=>[(0,b.Uk)(" "+(0,w.zw)(E.SysInfo.sysmc),1)])),_:1}),(0,b.Wm)(ce,null,{label:(0,b.w5)((()=>[(0,b.Wm)(fe,null,{default:(0,b.w5)((()=>[(0,b.Wm)(pe)])),_:1}),q])),default:(0,b.w5)((()=>[$])),_:1})])),_:1})):(0,b.kq)("",!0)])),_:1}),(0,b.Wm)(be,{label:"设备管理",name:"second"},{default:(0,b.w5)((()=>[(0,b.Wm)(de,{data:G.sbTableInfo,style:{width:"100%"}},{default:(0,b.w5)((()=>[(0,b.Wm)(se,{type:"index"}),(0,b.Wm)(se,{label:"设备名称",prop:"sbmc",width:"220rem"}),(0,b.Wm)(se,{label:"设备状态",prop:"state",width:"220rem"}),(0,b.Wm)(se,{label:"操作",width:"300rem"},{default:(0,b.w5)((e=>[(0,b.Wm)(ae,{title:"确定要删除该实验室?",onConfirm:s=>G.deleteDevice(e.row.sbh)},{reference:(0,b.w5)((()=>[(0,b.Wm)(ee,{type:"danger"},{default:(0,b.w5)((()=>[B])),_:1})])),_:2},1032,["onConfirm"])])),_:1})])),_:1},8,["data"])])),_:1}),(0,b.Wm)(be,{label:"添加设备",name:"third"},{default:(0,b.w5)((()=>[(0,b.Wm)(me,{ref:"addSbInfoRef",model:E.addSbInfo,"label-position":"left",class:"sys-form"},{default:(0,b.w5)((()=>[(0,b.Wm)(oe,{label:"设备的名称",prop:"sysmc",rules:[{required:!0,message:"必需填写,例如: 投影仪"}]},{default:(0,b.w5)((()=>[(0,b.Wm)(te,{modelValue:E.addSbInfo.sbmc,"onUpdate:modelValue":s[7]||(s[7]=e=>E.addSbInfo.sbmc=e),type:"text",autocomplete:"off"},null,8,["modelValue"])])),_:1}),(0,b.Wm)(oe,{label:"设备的状态",rules:[{required:!0,message:"必需选择，默认开放"}]},{default:(0,b.w5)((()=>[(0,b.Wm)(ne,{modelValue:E.addSbInfo.sbzt,"onUpdate:modelValue":s[8]||(s[8]=e=>E.addSbInfo.sbzt=e)},{default:(0,b.w5)((()=>[(0,b.Wm)(ie,{label:"0"},{default:(0,b.w5)((()=>[F])),_:1}),(0,b.Wm)(ie,{label:"1"},{default:(0,b.w5)((()=>[N])),_:1})])),_:1},8,["modelValue"])])),_:1}),(0,b.Wm)(oe,null,{default:(0,b.w5)((()=>[(0,b._)("div",R,[(0,b.Wm)(ee,{type:"primary",onClick:s[9]||(s[9]=e=>G.addSb())},{default:(0,b.w5)((()=>[T])),_:1}),(0,b.Wm)(ee,{onClick:s[10]||(s[10]=e=>G.resetForm("addSbInfoRef"))},{default:(0,b.w5)((()=>[A])),_:1})])])),_:1})])),_:1},8,["model"])])),_:1})])),_:1},8,["onTabClick","modelValue"])])),_:1},8,["modelValue","before-close"]),(0,b.Wm)(Se,{modelValue:S.addDialogVisible,"onUpdate:modelValue":s[20]||(s[20]=e=>S.addDialogVisible=e),title:"添加实验室",width:"60%","before-close":S.handleClose},{default:(0,b.w5)((()=>[(0,b.Wm)(we,{modelValue:S.activeName,"onUpdate:modelValue":s[19]||(s[19]=e=>S.activeName=e),onTabClick:G.handleClick},{default:(0,b.w5)((()=>[(0,b.Wm)(be,{label:"单个添加",name:"first"},{default:(0,b.w5)((()=>[(0,b.Wm)(me,{ref:"addSysInfoRef",model:E.addSysInfo,"label-position":"left",class:"sys-form"},{default:(0,b.w5)((()=>[(0,b.Wm)(oe,{label:"实验室的名称",prop:"sysmc",rules:[{required:!0,message:"非必需填写,例如: 人工智能实验室, 不填写的话默认名称: 机房"}]},{default:(0,b.w5)((()=>[(0,b.Wm)(te,{modelValue:E.addSysInfo.sysmc,"onUpdate:modelValue":s[13]||(s[13]=e=>E.addSysInfo.sysmc=e),type:"text",autocomplete:"off"},null,8,["modelValue"])])),_:1}),(0,b.Wm)(oe,{label:"实验室门牌号",prop:"sysmph",rules:[{required:!0,message:"必需填写,表示实验室位置,例如: 205"}]},{default:(0,b.w5)((()=>[(0,b.Wm)(te,{modelValue:E.addSysInfo.sysmph,"onUpdate:modelValue":s[14]||(s[14]=e=>E.addSysInfo.sysmph=e),type:"text",autocomplete:"off"},null,8,["modelValue"])])),_:1}),(0,b.Wm)(oe,{label:"实验室的容量",prop:"capacity",rules:[{required:!0,message:"必需填写,实验室的人数,例如: 40"}]},{default:(0,b.w5)((()=>[(0,b.Wm)(te,{modelValue:E.addSysInfo.capacity,"onUpdate:modelValue":s[15]||(s[15]=e=>E.addSysInfo.capacity=e),type:"number",min:"0",autocomplete:"off"},null,8,["modelValue"])])),_:1}),(0,b.Wm)(oe,{label:"实验室的类型",rules:[{required:!0,message:"必需选择，默认开放"}]},{default:(0,b.w5)((()=>[(0,b.Wm)(ne,{modelValue:E.addSysInfo.systype,"onUpdate:modelValue":s[16]||(s[16]=e=>E.addSysInfo.systype=e)},{default:(0,b.w5)((()=>[(0,b.Wm)(ie,{label:"0"},{default:(0,b.w5)((()=>[H])),_:1}),(0,b.Wm)(ie,{label:"1"},{default:(0,b.w5)((()=>[P])),_:1})])),_:1},8,["modelValue"])])),_:1}),(0,b.Wm)(oe,null,{default:(0,b.w5)((()=>[(0,b._)("div",j,[(0,b.Wm)(ee,{type:"primary",onClick:s[17]||(s[17]=e=>G.addSys("addSysInfoRef"))},{default:(0,b.w5)((()=>[J])),_:1}),(0,b.Wm)(ee,{onClick:s[18]||(s[18]=e=>G.resetForm("addSysInfoRef"))},{default:(0,b.w5)((()=>[M])),_:1})])])),_:1})])),_:1},8,["model"])])),_:1}),(0,b.Wm)(be,{label:"批量添加",name:"second"},{default:(0,b.w5)((()=>[(0,b._)("div",O,[(0,b.Wm)(ge,{drag:"",action:"","http-request":G.uploadCSVFile,limit:1,accept:".csv"},{tip:(0,b.w5)((()=>[Q])),default:(0,b.w5)((()=>[(0,b.Wm)(fe,{class:"el-icon--upload"},{default:(0,b.w5)((()=>[(0,b.Wm)(Ie)])),_:1}),K])),_:1},8,["http-request"]),(0,b.Wm)(ee,{type:"primary"},{default:(0,b.w5)((()=>[Z])),_:1})])])),_:1})])),_:1},8,["modelValue","onTabClick"])])),_:1},8,["modelValue","before-close"])])),_:1})}var G=t(1897),X=t(5574),ee=(t(3970),t(7233),t(4870)),se=t(2826),te={setup(){const e=(0,ee.iH)(!1),s=(0,ee.iH)(!1),t=(0,ee.iH)("first"),a=(0,ee.iH)("first"),l=e=>{G.T.confirm("确定关闭对话框?","温馨提示",{type:"info",center:!0}).then((()=>{e()}))};return{dialogVisible:e,handleClose:l,addDialogVisible:s,activeName:t,manageActiveName:a}},data(){return{currentPage:1,pagesize:10,search:"",Yxs:{},SysList:[],SysInfo:{sysh:"",sysmc:"",sysmph:"",systype:"",yxsh:"",yxmc:""},addSysInfo:{sysmc:"",sysmph:"",capacity:"",systype:"0"},sbList:[],addSbInfo:{sysh:"",sbmc:"",sbzt:"0"}}},created(){const e=sessionStorage.getItem("userInfo");e?this.userInfo=JSON.parse((0,se.Ne)(e)):this.$router.push("/login"),this.getSysListById(this.userInfo.yxsh),this.getYxsById(this.userInfo.yxsh)},methods:{handleClick(e,s){console.log(e,s)},clearSysInfo(){this.SysInfo={sysh:"",sysmc:"",sysmph:"",yxsh:"",yxmc:"",capacity:"",systype:0}},claearAddSbInfo(){this.addSbInfo={sysh:"",sbmc:"",sbzt:"0"}},resetForm(e){this.$refs[e].resetFields(),this.clearSysInfo(),this.claearAddSbInfo()},handleSizeChange:function(e){this.pagesize=e},handleCurrentChange:function(e){this.currentPage=e},getYxsById(e){this.$axios.post("/weixin-yxs/yxsById",{id:e}).then((e=>{const s=e.data;200==s.code&&(this.Yxs=s.data)}))},getSysListById(e){this.$axios.get("/weixin-syszk/getById?id="+e).then((e=>{const s=e.data;200==s.code&&(this.SysList=s.data)}))},deleteSysById(e){this.$axios.post("/weixin-syszk/deleteById?id="+e).then((e=>{const s=e.data;200==s.code?(X.z8.success("删除成功"),Loading.show(),this.getSysListById(this.YxsId),Loading.hide()):X.z8.error("删除错误")}))},changeSysInfo(e){this.SysInfo=null,this.dialogVisible=!0,this.SysInfo=JSON.parse(JSON.stringify(e)),Loading.show(),this.devicelist(this.SysInfo.sysh),Loading.hide()},updateSysInfo(e){this.$refs[e].validate((e=>{e?this.$axios.post("/weixin-syszk/updateSysInfo",{sysh:this.SysInfo.sysh,sysmc:this.SysInfo.sysmc,sysmph:this.SysInfo.sysmph,capacity:this.SysInfo.capacity,systype:this.SysInfo.systype}).then((e=>{const s=e.data;200==s.code&&(X.z8.success("更新数据成功"),this.dialogVisible=!1,this.getSysListById(this.YxsId))})):X.z8.error("表单不合法！！")}))},addSysDialog(){this.addDialogVisible=!0},addSys(e){this.$refs[e].validate((e=>{e&&this.$axios.post("/weixin-syszk/addSys",{sysmc:this.addSysInfo.sysmc,sysmph:this.addSysInfo.sysmph,capacity:this.addSysInfo.capacity,systype:this.addSysInfo.systype,yxsh:this.YxsId,yxmc:this.YxsMc}).then((e=>{const s=e.data;200==s.code?(X.z8.success("添加成功"),Loading.show(),this.getSysListById(this.YxsId),Loading.hide(),this.addDialogVisible=!1):X.z8.error(s.msg)}))}))},uploadCSVFile(e){const s=e.file;let t=new FormData;t.append("file",s),t.append("YxsId",this.YxsId),t.append("YxsMc",this.YxsMc),console.log(t),this.$axios({url:"/weixin-syszk/addSYSList",method:"post",data:t,headers:{"Content-Type":"multipart/form-data"}}).then((e=>{const s=e.data;200==s.code?(X.z8.success("添加成功"),location.reload()):X.z8.error(s.msg)}))},addSb(){""!=this.SysInfo.sysh&&(this.addSbInfo.sysh=this.SysInfo.sysh,Loading.show(),this.addDevice(),Loading.hide(),this.claearAddSbInfo())},devicelist(e){this.$axios.post("/weixin-sbzk/deviceList",{sysh:e}).then((e=>{const s=e.data;200==s.code?this.sbList=s.data:X.z8.error("获取设备列表失败")}))},deleteDevice(e){this.$axios.post("/weixin-sbzk/deleteDevice",{sbh:e}).then((e=>{const s=e.data;200==s.code&&(this.devicelist(this.SysInfo.sysh),X.z8.success("删除成功"))}))},addDevice(){""!=this.addSbInfo.sbmc&&""!=this.addSbInfo.sysh&&""!=this.addSbInfo.sbzt?this.$axios.post("/weixin-sbzk/addDevice",this.addSbInfo).then((e=>{const s=e.data;200==s.code&&(X.z8.success("添加成功"),this.devicelist(this.SysInfo.sysh))})):X.z8.error("请填写设备信息")},tabsClick(e){}},computed:{getSysFilter(){return this.SysList.map((e=>(0==e.systype?e["state"]="开放":1==e.systype?e["state"]="禁用":e["state"]="报修",e))).filter((e=>!this.search||e.sysmc.includes(this.search.toLowerCase())||e.sysmph.includes(this.search.toLowerCase())||e.state.includes(this.search.toLowerCase())))},sbTableInfo(){return this.sbList.map((e=>(e["state"]="0"==e.sbzt?"正常":"故障",e)))}}},ae=t(89);const le=(0,ae.Z)(te,[["render",E],["__scopeId","data-v-f5d04436"]]);var de=le},6809:function(e,s,t){t(1758)},7437:function(e,s,t){t(1758)},88:function(e,s,t){t(1758)},7579:function(e,s,t){t(1758)},877:function(e,s,t){t(1758),t(7579)},9910:function(e,s,t){t(1758),t(7195)},7219:function(e,s,t){t(1758)},7113:function(e,s,t){t(1758)},2064:function(e,s,t){t(1758)},172:function(e,s,t){t(1758)},3970:function(e,s,t){t(1758),t(6809),t(172),t(7195)},7960:function(e,s,t){t(1758)},7195:function(e,s,t){t(1758)},3069:function(e,s,t){t(1758),t(3877)},3855:function(e,s,t){t(1758),t(6962)},2942:function(e,s,t){t(1758)},3429:function(e,s,t){t(1758)},451:function(e,s,t){t(1758)},3877:function(e,s,t){t(1758),t(172),t(1430),t(7960),t(451),t(6467)},6226:function(e,s,t){t(1758)},9007:function(e,s,t){t(1758),t(88),t(1430)},6905:function(e,s,t){t(1758),t(88),t(1430),t(4566),t(451)},33:function(e,s,t){t(1758)},7500:function(e,s,t){t(1758)}}]);
//# sourceMappingURL=919.989c09bc.js.map