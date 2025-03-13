
# Backend For Blogs

It is a java based backend server created with springboot.




## Features

- Handle CRUD Operations
- Live previews
- Deployed in AWS
- Can Also talk to AI




## Environment Variables

To run this project, you will need to add the following environment variables to your .env file

`Gemini_KEY`

`spring.datasource.url`
`spring.datasource.username`
`spring.datasource.password`


## API Reference

#### Get all blogs

```http
  GETAllBlogsByPagination /api/blogs
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `page` | `interger` | **Optional**. Your API key |
| `size` | `interger` | **Optional**. Your API key |

#### Get Blog

```http
  GETById /api/blogs/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `long` | **Required**. Id of blog to fetch |


#### Post Blog

```http
  POST /api/blogs
```

| Body | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| raw      | `Blog` | title:String,content:String,author:String**Required**|   Raw Data of blog to create |


#### Get Blog

```http
  GETById /api/blogs/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `long` | **Required**. Id of blog to fetch |


#### Delete Blog

```http
  DeleteById /api/blogs/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `long` | **Required**. Id of blog to delete |



#### Put(Update) Blog

```http
  UpdateById /api/blogs/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `long` | **Required**. Id of blog to update |
| `raw`      | `Blog` | **Required**. what to update in specific blog |






#### Get Summary

```http
  GETBYContent /api/blogs/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `content`      | `String` | **Required**. content of blog to summarize |



