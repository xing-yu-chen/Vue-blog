<template>
	<div>
		<Header></Header>
		<el-timeline>
			<el-timeline-item :timestamp="blog.created" placement="top" v-for="blog in blogs">
				<el-card>
					<h4>
						<!--使用注意-->
						<router-link :to="{name:'BlogDetail',params:{blogId: blog.id}}">{{blog.title}}</router-link>
					</h4>
					<p>{{blog.description}}</p>
				</el-card>
			</el-timeline-item>
		</el-timeline>
		<el-pagination background layout="prev, pager, next" :current-page="currentPage" @current-change="page" :page-size="pageSize" :total="total">
		</el-pagination>
	</div>
</template>

<script>
	import Header from '../components/Header.vue'
	export default {
		name: 'Blogs',
		components: {
			Header
		},
		data(){
			return{
				blogs:{},
				currentPage:1.,
				total:0,
				pageSize:5
			}
		},
		methods:{
			page(currentPage){
				this.$axios.get("/blog/blogs?currentPage="+currentPage).then(res=>{
					this.blogs=res.data.data.records;
					this.currentPage=res.data.data.current;
					this.total=res.data.data.total;
					this.pageSize=res.data.data.size;
				})
			}
		},
		created(){
			this.page(1);
		}
	}
</script>

<style scoped>
</style>
