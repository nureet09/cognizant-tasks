import React, { Component } from 'react';

class Posts extends Component {
    constructor(props) {
        super(props);
        this.state = {
            posts: [],
            hasError: false
        };
    }

    // Custom method to fetch data from the external API endpoint
    loadPosts() {
        fetch('https://jsonplaceholder.typicode.com/posts')
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => {
                // Map the raw JSON array to the state configuration
                this.setState({ posts: data });
            })
            .catch(error => {
                console.error("Fetch error: ", error);
                this.setState({ hasError: true });
            });
    }

    // Lifecycle hook: runs immediately after the component mounts to the DOM
    componentDidMount() {
        this.loadPosts();
    }

    // Lifecycle hook: catches rendering errors in child components
    componentDidCatch(error, info) {
        this.setState({ hasError: true });
        alert("An error occurred in the component: " + error.message);
    }

    render() {
        if (this.state.hasError) {
            return <div className="error-msg"><p>Something went wrong loading the posts.</p></div>;
        }

        return (
            <div style={{ padding: '20px' }}>
                <h2>Blog Posts Repository</h2>
                {this.state.posts.map(post => (
                    <div key={post.id} style={{ borderBottom: '1px solid #ccc', margin: '10px 0', paddingBottom: '10px' }}>
                        <h3>{post.title}</h3>
                        <p>{post.body}</p>
                    </div>
                ))}
            </div>
        );
    }
}

export default Posts;