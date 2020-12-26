<template>
  <div>
    <el-form ref="loginForm" :model="loginForm" auto-complete="on" label-position="left">
      <div>
        <h3>Login Form</h3>
      </div>
      <el-form-item prop="username">
        <el-input
          ref="username"
          v-model="loginForm.username"
          placeholder="Username"
          name="username"
          type="text"
          tabindex="1"
          auto-complete="on"
        />
      </el-form-item>
      <el-form-item prop="password">
        <el-input
          :key="passwordType"
          ref="password"
          v-model="loginForm.password"
          :type="passwordType"
          placeholder="Password"
          name="password"
          tabindex="2"
          auto-complete="on"
          @keyup.enter.native="handleLogin"
        />
      </el-form-item>
      <el-button :loading="loading" type="primary" @click.native.prevent="handleLogin">Login</el-button>
    </el-form>
  </div>
</template>

<script>

export default {
  name: 'Login',
  data() {
    return {
      loginForm: {
        username: 'admin',
        password: '1234567'
      },
      loading: false,
      passwordType: 'password',
      redirect: undefined
    }
  },
  methods: {
    handleLogin() {
      this.$axios.post("/login", this.loginForm).then(res => {
        console.log(res);
        this.$router.push("/dashboard")
      });
    }
  }
}
</script>

<style>

</style>
