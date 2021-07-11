<template>
	<div class="header_box">
		<h1>欢迎来到xingyuhub的博客</h1>
		<el-avatar :size="100" :src="user.avatar">Xing-Yu</el-avatar>
		<h3>{{ user.username }}</h3>
		<div>
			<span>
				<el-link href="/blogs">主页</el-link>
			</span>
			<el-divider direction="vertical"></el-divider>
			<span>
				<el-link type="success" href="/blogs/add" :disabled="!hasLogin">发表文章</el-link>
			</span>
			<el-divider direction="vertical"></el-divider>
			<span v-if="!hasLogin">
				<el-link type="info" href="/login">登录</el-link>
			</span>
			<span v-if="hasLogin">
				<el-link type="danger" @click.prevent="logout">退出</el-link>
			</span>
		</div>
	</div>
</template>

<script>
	export default {
		name: 'Header',
		data() {
			return {
				user: {
					username: '',
					avatar: ''
				},
				hasLogin: false
			}
		},
		methods: {
			logout() {
				const _this = this;
				_this.$axios.get("http://localhost:8080/logout").then(res => {
					_this.hasLogin = false;
					_this.$store.commit("REMOVE_INFO");
					_this.$router.push("/login");
				});
			}
		},
		created() {
			if (this.$store.getters.getUserInfo.username) {
				this.user.username = this.$store.getters.getUserInfo.username;
			}
			if (this.$store.getters.getUserInfo.avatar) {
				this.user.avatar = this.$store.getters.getUserInfo.avatar;
			}
			if (localStorage.getItem("token")) {
				this.hasLogin = true;
			}
		}
	}
</script>

<style scoped="scoped">
	.header_box {
		max-width: 800px;
		text-align: center;
		margin: 0 auto;
	}
</style>
