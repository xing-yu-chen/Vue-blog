<template>
	<div>
		<Header></Header>
		<div class="m-content">
			<el-form ref="editForm" status-icon :model="editForm" :rules="rules" label-width="80px">
				<el-form-item label="标题" prop="title">
					<el-input v-model="editForm.title"></el-input>
				</el-form-item>
				<el-form-item label="摘要" prop="description">
					<el-input type="textarea" v-model="editForm.description"></el-input>
				</el-form-item>
				<el-form-item label="内容" prop="content">
					<v-md-editor v-model="editForm.content"></v-md-editor>
				</el-form-item>
				<el-form-item>
					<el-button type="primary" @click="submitForm('editForm')">立即创建</el-button>
					<el-button>取消</el-button>
				</el-form-item>
			</el-form>
		</div>
	</div>
</template>

<script>
	import Header from '../components/Header.vue'
	export default {
		name: 'BlogEdit',
		components: {
			Header
		},
		data() {
			return {
				editForm: {
					id: null,
					title: '',
					description: '',
					content: ''
				},
				rules: {
					title: [{
							required: true,
							message: '请输入标题',
							trigger: 'blur'
						},
						{
							min: 3,
							max: 50,
							message: '长度在 3 到 50 个字符',
							trigger: 'blur'
						}
					],
					description: [{
						required: true,
						message: '请输入摘要',
						trigger: 'blur'
					}]
				}
			}
		},
		methods: {
			submitForm(editForm) {
				this.$refs[editForm].validate((valid) => {
					if (valid) {
						this.$axios.post('/blog/edit',this.editForm)
						.then(res=>{
							this.$alert('操作成功', '操作', {
							          confirmButtonText: '确定',
							          callback: action => {
							            this.$router.push("/blogs")
							          }
							        });
						});
					} else {
						console.log('error submit!!');
						return false;
					}
				});
			},
			resetForm(editForm) {
				this.$refs[editForm].resetFields();
			}
		},
		created(){
			let blogId=this.$route.params.blogId;
			this.$axios.get("/blog/blogs/"+blogId)
			.then(res=>{
				this.editForm.title=res.data.data.title;
				this.editForm.description=res.data.data.description;
				this.editForm.content=res.data.data.content;
			});
		}
	}
</script>

<style>
</style>
