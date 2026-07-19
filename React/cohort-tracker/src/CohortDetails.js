import React from 'react';
import styles from './CohortDetails.module.css'; // Step 8: Import the CSS Module

function CohortDetails({ id, title, startDate, status, coach, trainer }) {
    // Step 10: Dynamic condition - "green" font if ongoing, "blue" for all other scenarios
    const headerColor = status.toLowerCase() === 'ongoing' ? 'green' : 'blue';

    return (
        // Step 9: Apply the box class to the container div
        <div className={styles.box}>
            <h3 style={{ color: headerColor }}>{id} - {title}</h3>
            
            <dl>
                <dt>Started On</dt>
                <dd>{startDate}</dd>
                
                <dt>Current Status</dt>
                <dd>{status}</dd>
                
                <dt>Coach</dt>
                <dd>{coach}</dd>
                
                <dt>Trainer</dt>
                <dd>{trainer}</dd>
            </dl>
        </div>
    );
}

export default CohortDetails;