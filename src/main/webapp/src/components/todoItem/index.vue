<template>
  <li>{{ todo.text }}</li>
</template>

<script>
  export default {
    name: 'todoItem',
    props: ['todo']
  }
</script>