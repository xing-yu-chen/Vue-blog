<template>
	<div>
		<Header></Header>
		<div class="box">
			<h2>{{blog.title}}</h2>
			<el-divider></el-divider>
			 <el-link icon="el-icon-edit" v-show="isUser">
				 <router-link :to="{name:'BlogEdit', params: {blogId:blog.id}}">编辑</router-link>
			 </el-link>
			<div class="content markdown-body" v-html="blog.content"></div>
			
		</div>
	</div>
</template>

<script>
	import Header from '../components/Header.vue'
	import 'github-markdown-css/github-markdown.css'
	export default{
		name: 'BlogDetail',
		components:{
			Header
		},
		data(){
			return {
				blog:{
					id:"",
					title:"",
					content:""
				},
				isUser:false
			}
		},
		created(){
			
			this.$axios.get("/blog/blogs/"+this.$route.params.blogId)
			.then(res=>{
				this.blog.id=this.$route.params.blogId;
				this.blog.title=res.data.data.title;
				this.blog.content=res.data.data.content;
				if(this.isUser=(res.data.data.userId == this.$store.getters.getUserInfo.id)){
					this.isUser=true;
				}
				console.log(res.data)
				//content之前进行渲染
				var MarkdownIt=require("markdown-it");
				var md=new MarkdownIt();
				//把本身的markown的内容经过渲染得到html的内容
				var result=md.render(this.blog.content);
				this.blog.content=result;
				
			})
		}
	}
</script>

<style scoped="scoped">
	.box{
		box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
		width: 100%;;
		min-height: 700px;
	}
</style>
